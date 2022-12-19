<script setup>
import { ref } from "vue";
import { getCourses } from "../apis/student-api";

let form = ref();

getCourses({ sno: 1, term: "2022-2023-1" }, ({ data }) => {
  form.value = data;
});
</script>

<template>
  <div class="course">
    <el-table :data="form" border stripe style="width: 100%">
      <el-table-column prop="course.name" label="课程名称" />
      <el-table-column prop="course.property" label="课程性质" />
      <el-table-column prop="course.credit" label="学分" />
      <el-table-column prop="term" label="学期" />
      <el-table-column prop="teacher.name" label="任课老师" />
    </el-table>
  </div>
</template>

<style scoped lang="scss">
</style>