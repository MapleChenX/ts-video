<script setup>
import { ref } from "vue";
import { getCoursesScore } from "../apis/student-api";

let form = ref();

getCoursesScore({ sno: 1 }, ({ data }) => {
  form.value = data;
});
</script>

<template>
  <div class="course-score">
    <el-table :data="form" border stripe style="width: 100%">
      <el-table-column prop="course.name" label="课程名称" />
      <el-table-column prop="score" label="课程成绩" />
      <el-table-column prop="course.credit" label="学分" />
      <el-table-column prop="term" label="学期" />
      <el-table-column prop="teacher.name" label="任课老师" />
    </el-table>
  </div>
</template>

<style scoped lang="scss">
</style>