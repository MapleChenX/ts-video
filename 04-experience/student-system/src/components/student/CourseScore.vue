<script setup>
import { ref, watch } from "vue";
import { getCoursesScore } from "@/apis/student-api.js";

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

getCoursesScore({ sno: 42020306, term: selectedTerm.value }, ({ data }) => {
  form.value = data;
});

watch(selectedTerm, () => {
  getCoursesScore({ sno: 42020306, term: selectedTerm.value }, ({ data }) => {
    form.value = data;
  });
});

let scores = ref([
  {
    value: "more",
    label: "大于"
  },
  {
    value: "less",
    label: "小于"
  },
  {
    value: "all",
    label: "全部"
  }
]);
let inputScore = ref();
let selectedScore = ref("all");

function reQuery() {
  let score = inputScore.value;
  if (selectedScore.value === "all") {
    score = null;
  }
  getCoursesScore({
    sno: 42020306, term: selectedTerm.value, [selectedScore.value]: score
  }, ({ data }) => {
    form.value = data;
  });
}
</script>

<template>
  <div class="course-score">
    <el-row style="margin-bottom: 20px;">
      <el-col>
        <el-row>
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
      </el-col>
      <el-col style="margin-top: 20px">
        <el-row justify="start" :gutter="10">
          <el-col :span="2">筛选成绩：</el-col>
          <el-col :span="5">
            <el-select v-model="selectedScore" placeholder="筛选成绩">
              <el-option
                v-for="item in scores"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              />
            </el-select>
          </el-col>
          <el-col :span="2">筛选分数：</el-col>
          <el-col :span="4">
            <el-input v-model="inputScore" />
          </el-col>
          <el-col :span="2">
            <el-button @click="reQuery" type="primary">查询</el-button>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
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