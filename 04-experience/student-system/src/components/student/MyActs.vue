<script setup>
import { ref, watch } from "vue";
import { getActs, getCoursesScore } from "@/apis/student-api.js";

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

getActs({ sno: item.sno, term: selectedTerm.value }, ({ data }) => {
  form.value = data;
});

watch(selectedTerm, () => {
  getActs({ sno: item.sno, term: selectedTerm.value }, ({ data }) => {
    form.value = data;
  });
});

let types = ref([
  {
    value: 2,
    label: "素拓"
  },
  {
    value: 1,
    label: "二课"
  },
  {
    value: 3,
    label: "全部"
  }
]);
let selectedType = ref(3);

watch(selectedType, () => {
  let type = selectedType.value;
  if (type === 3) {
    type = null;
  }
  getActs({ sno: item.sno, type }, ({ data }) => {
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
  getActs({
    sno: item.sno, term: selectedTerm.value, [selectedScore.value]: score
  }, ({ data }) => {
    form.value = data;
  });
}
</script>

<template>
  <el-row style="margin-bottom: 20px;">
    <el-col :span="12">
      <el-row>
        <el-col :span="4">选择学期：</el-col>
        <el-col :span="18">
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
    <el-col :span="12">
      <el-row>
        <el-col :span="6">选择活动类型：</el-col>
        <el-col :span="18">
          <el-select v-model="selectedType" placeholder="切换学期">
            <el-option
              v-for="item in types"
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
        <el-col :span="2">筛选：</el-col>
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
        <el-col :span="2">分数：</el-col>
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
    <el-table-column prop="createDate" label="日期" />
    <el-table-column prop="name" label="名称" />
    <el-table-column prop="sgenre" label="活动性质" />
    <el-table-column prop="stype" label="活动类型" />
    <el-table-column prop="term" label="学期" />
    <el-table-column prop="score" label="加分情况" />
  </el-table>
</template>

<style scoped lang="css">
</style>