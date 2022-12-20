<script setup>
import { ref, watch } from "vue";
import { getCourses } from "@/apis/student-api.js";

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

getCourses({ sno: 42020306, term: selectedTerm.value }, ({ data }) => {
  form.value = data;
});

watch(selectedTerm, () => {
  getCourses({ sno: 42020306, term: selectedTerm.value }, ({ data }) => {
    form.value = data;
  });
});
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
      <el-table-column prop="course.property" label="课程性质" />
      <el-table-column prop="course.credit" label="学分" />
      <el-table-column prop="term" label="学期" />
      <el-table-column prop="teacher.name" label="任课老师" />
    </el-table>
  </div>
</template>

<style scoped lang="scss">
</style>