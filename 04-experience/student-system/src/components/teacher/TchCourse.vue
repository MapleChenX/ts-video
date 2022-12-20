<script setup>
import { ref, watch } from "vue";
import { getCourses } from "@/apis/teacher-api.js";
import { useRouter } from "vue-router";

let form = ref();
let terms = ref([
  {
    value: "2022-2023-1",
    label: "2022-2023-1"
  },
  {
    value: "2022-2023-2",
    label: "2022-2023-2"
  },
  {
    value: "2023-2024-1",
    label: "2023-2024-1"
  },
  {
    value: "2023-2024-2",
    label: "2023-2024-2"
  }
]);
let selectedTerm = ref("2022-2023-1");
let item = JSON.parse(localStorage.getItem("user"));

getCourses({ tno: item.tno, term: selectedTerm.value }, ({ data }) => {
  form.value = data;
});

watch(selectedTerm, () => {
  getCourses({ tno: item.tno, term: selectedTerm.value }, ({ data }) => {
    form.value = data;
  });
});

const router = useRouter();

function handleEdit(index, row) {
  let term = row.term;
  let gno = row.grade.gno;
  let tno = row.teacher.tno;
  let name = row.course.name;
  router.push({
    name: "TchCourseScore", query: {
      term, gno, tno, name
    }
  });
}
</script>

<template>
  <div class="course">
    <el-row style="margin-bottom: 20px;">
      <el-col :span="2">选择学期：</el-col>
      <el-col :span="22">
        <el-select v-model="selectedTerm" placeholder="切换学期">
          <el-option
            v-for="item in terms"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </el-col>
    </el-row>
    <el-table :data="form" border stripe style="width: 100%">
      <el-table-column prop="course.name" label="课程名称" />
      <el-table-column prop="grade.name" label="课程班级" />
      <el-table-column prop="grade.grade" label="年级" />
      <el-table-column prop="term" label="学期" />
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)">
            录入成绩
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped lang="scss">
</style>