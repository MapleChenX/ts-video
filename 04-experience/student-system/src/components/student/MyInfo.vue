<script setup>
import { ref } from "vue";
import { ElMessage } from "element-plus";
import { Warning, Clock, Aim, Histogram } from "@element-plus/icons-vue";
import { getSelf, updateSelf } from "@/apis/student-api.js";

let form = ref();
let student;
let item = JSON.parse(localStorage.getItem("user"));

getSelf({ sno: item.sno }, ({ data }) => {
  form.value = data;
  student = JSON.parse(JSON.stringify(form.value.student));
});

function reset() {
  form.value.student = student;
}

function submit() {
  updateSelf(form.value.student, ({ data }) => {
    if (data.code === 200) {
      ElMessage({
        message: "更新基本信息成功！",
        grouping: true,
        type: "success"
      });
    } else {
      ElMessage({
        message: "更新基本信息失败！请联系管理员",
        grouping: true,
        type: "error"
      });
      reset();
    }
  });
}
</script>

<template>
  <div class="login-date">
    <el-icon>
      <Clock />
    </el-icon>
    上次登录日期：{{ form.student.loginDate }}
  </div>
  <div class="label">
    <el-icon>
      <Warning />
    </el-icon>
    基本信息：
  </div>
  <el-form label-position="right" :model="form.student" label-width="120px">
    <el-form-item label="姓名：">
      {{ form.student.name }}
    </el-form-item>
    <el-form-item label="学号：">
      {{ form.student.sno }}
    </el-form-item>
    <el-form-item label="年龄：">
      {{ form.student.age }}
    </el-form-item>
    <el-form-item label="性别：">
      {{ form.student.sex == 1 ? "男" : "女" }}
    </el-form-item>
    <el-form-item label="民族：">
      {{ form.student.nation }}
    </el-form-item>
    <el-form-item label="学生类别：">
      {{ form.student.stuType }}
    </el-form-item>
    <el-form-item label="考生类别：">
      {{ form.student.examType }}
    </el-form-item>
    <el-form-item label="身份证号：">
      {{ form.student.indenti }}
    </el-form-item>
    <el-form-item label="电子邮箱：">
      <el-input style="width: 30vw" v-model="form.student.email" />
    </el-form-item>
    <el-form-item label="出生日期：">
      {{ form.student.birthday }}
    </el-form-item>
    <el-form-item label="家庭住址：">
      {{ form.student.homeAddr }}
    </el-form-item>
    <el-form-item label="现居地址：">
      <el-input style="width: 30vw" v-model="form.student.nowAddr" />
    </el-form-item>
    <el-form-item label="QQ号：">
      <el-input style="width: 30vw" v-model="form.student.qq" />
    </el-form-item>
    <el-form-item label="手机号：">
      <el-input style="width: 30vw" v-model="form.student.phone" />
    </el-form-item>
    <el-form-item label="银行：">
      <el-row :gutter="20">
        <el-col :span="8">
          <el-input v-model="form.student.bankName" />
        </el-col>
        <el-col :span="16">
          <el-input v-model="form.student.bankNo" />
        </el-col>
      </el-row>
    </el-form-item>
    <el-form-item>
      <div style="margin-top: 20px">
        <el-button @click="submit">保存设置</el-button>
        <el-button type="primary" @click="reset">恢复默认</el-button>
      </div>
    </el-form-item>
  </el-form>
  <div class="label">
    <el-icon>
      <Aim />
    </el-icon>
    专业信息：
  </div>
  <el-form :model="form.profession">
    <el-form-item label="专业名称：">
      {{ form.profession.name }}
    </el-form-item>
    <el-form-item label="专业代码：">
      {{ form.profession.code }}
    </el-form-item>
    <el-form-item label="专业学制：">
      {{ form.profession.eduSys }}
    </el-form-item>
    <el-form-item label="专业类型：">
      {{ form.profession.type }}
    </el-form-item>
    <el-form-item label="授予学位：">
      {{ form.profession.degree }}
    </el-form-item>
  </el-form>
  <div class="label">
    <el-icon>
      <Histogram />
    </el-icon>
    班级信息：
  </div>
  <el-form :model="form.grade">
    <el-form-item label="年级：">
      {{ form.grade.grade }}
    </el-form-item>
    <el-form-item label="层次：">
      {{ form.grade.layer }}
    </el-form-item>
    <el-form-item label="班级：">
      {{ form.grade.name }}
    </el-form-item>
    <el-form-item label="学院：">
      {{ form.college.name }}
    </el-form-item>
  </el-form>
</template>

<style scoped lang="css">
.login-date {
  font-size: 14px;
  margin-bottom: 20px;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  align-items: center;
  align-content: center;
}

.label {
  font-size: 16px;
  margin-bottom: 10px;
  font-weight: 600;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-items: center;
  align-content: center;
}
</style>