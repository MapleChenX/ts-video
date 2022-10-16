<template>
  <div class="header flex row align-center justify-between items-center radius">
    <div class="left">
      <a href="https://www.cnblogs.com/Enziandom/">{{ user.showName }}</a>
    </div>
    <ul class="right flex row">
      <li class="item"><router-link to="/">首页</router-link></li>
      <li class="item"><router-link to="/">标签</router-link></li>
      <li class="item"><router-link to="/h/new/post">新随笔</router-link></li>
      <li class="item"><router-link to="/h/manage/post">管理</router-link></li>
    </ul>
  </div>
</template>

<script setup>
import { defineProps } from "vue";

const props = defineProps({
  user: {
    type: Object,
    required: true
  }
});
</script>

<style scoped>
.header {
  height: 8vh;
  width: 100%;
  padding: 10px 20px;
  box-sizing: border-box;
  margin-bottom: 1vh;
  background-color: var(--card-bg-color);
}

.header .left {
  font-size: 22px;
}

.header .right li {
  margin: 0 10px;
}

.header .right li:first-child {
  margin: 0 10px 0 0;
}

.header .right li:last-child {
  margin: 0 0 0 10px;
}
</style>
