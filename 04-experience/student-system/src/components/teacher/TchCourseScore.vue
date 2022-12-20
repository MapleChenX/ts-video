<script setup>
import { ref } from "vue";
import { ElMessage } from "element-plus";
import { useRoute } from "vue-router";
import { getStuCourses, updateStuCourseScore } from "@/apis/teacher-api";
import { getCoursesScore } from "@/apis/student-api";

const route = useRoute();

let form = ref();
let item = JSON.parse(localStorage.getItem("user"));

getStuCourses({
  tno: route.query.tno,
  term: route.query.term,
  gno: route.query.gno,
  name: route.query.name
}, ({ data }) => {
  form.value = data;
});

let row = ref();
let dialog = ref(false);
let selectedName = ref();

function luru(data) {
  selectedName.value = data.source.student.name;
  getCoursesScore({
    sno: data.stuId,
    teacherId: data.teacherId,
    term: data.term,
    courseId: data.courseId
  }, ({ data }) => {
    row.value = data;
    dialog.value = !dialog.value;
  });
}

function submit() {
  updateStuCourseScore({
    score: row.value[0].score,
    sno: row.value[0].stuId,
    courseId: row.value[0].course.cno,
    term: row.value[0].term,
    tno: row.value[0].teacher.tno
  }, ({ data }) => {
    if (data.code === 200) {
      ElMessage({
        message: "录入成绩成功！",
        grouping: true,
        type: "success"
      });
    } else {
      ElMessage({
        message: "录入成绩失败！",
        grouping: true,
        type: "error"
      });
    }
    dialog.value = !dialog.value;
  });
}
</script>

<template>
  <div class="course-score">
    <div class="name">
      当前录入课程名称：{{ form[0].course.name }}
    </div>
    <div class="term">
      录入课程学期：{{ form[0].term }}
    </div>
    <div class="grade">
      录入班级：{{ form[0].source.grade.grade }}级{{ form[0].source.grade.layer }}{{ form[0].source.grade.name }}
    </div>
    <el-table :data="form" border stripe style="width: 100%">
      <el-table-column prop="source.student.sno" label="学号" />
      <el-table-column prop="source.student.name" label="姓名" />
      <el-table-column label="性别">
        <template #default="scope">
          {{ scope.row.source.student.sex === 1 ? "男" : "女" }}
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button @click="luru(scope.row)">录入</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog v-model="dialog" title="录入成绩面板">
      <div class="label">
        姓名：{{ selectedName }}
      </div>
      <div class="label">
        学号：{{ row[0].stuId }}
      </div>
      <div class="label">
        课程：{{ row[0].course.name }}
      </div>
      <div class="label">
        <el-row>
          <el-col :span="2">
            成绩：
          </el-col>
          <el-col :span="10">
            <el-input v-model="row[0].score"></el-input>
          </el-col>
        </el-row>
      </div>
      <div>
        <el-button @click="submit">确定录入</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<style scoped lang="css">
.name, .term {
  margin-bottom: 10px;
}

.grade {
  margin-bottom: 20px;
}

.label {
  font-size: 17px;
  margin-bottom: 17px;
}
</style>