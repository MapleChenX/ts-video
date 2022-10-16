<template>
  <div class="header flex row align-center justify-between items-center radius">
    <div class="left">
      <a href="https://www.cnblogs.com/Enziandom/">{{ user.showName }}</a>
    </div>
    <ul class="right flex row align-center items-center justify-center">
      <li class="item flex align-center items-center justify-center">
        <router-link class="flex align-center items-center justify-center" to="/h/posts">首页</router-link>
      </li>
      <li class="item flex align-center items-center justify-center">
        <router-link class="flex align-center items-center justify-center" to="/h/square">广场</router-link>
      </li>
      <li class="item flex align-center items-center justify-center">
        <router-link class="flex align-center items-center justify-center" to="/h/new/post">新建随笔</router-link>
      </li>
      <li class="item flex align-center items-center justify-center">
        <router-link class="flex align-center items-center justify-center" to="/h/manage/post">管理随笔</router-link>
      </li>
      <li class="item"><el-button @click="quit" size="small">注销</el-button></li>
    </ul>
  </div>
</template>

<script setup>
import { defineProps } from "vue";
import { useRouter } from "vue-router";
import { useCookies } from "@vueuse/integrations/useCookies";
import { ElMessage } from "element-plus";

const router = useRouter();
const { remove } = useCookies();

const props = defineProps({
  user: {
    type: Object,
    required: true
  }
});

function quit() {
  remove("signed", { domain: "localhost", path: "/" });
  setTimeout(() => {
    router.push("/login");
    ElMessage({
      center: true,
      message: "注销成功",
      type: "success"
    });
  }, 500);
}
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
