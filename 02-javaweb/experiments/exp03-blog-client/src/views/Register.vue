<template>
  <div class="register flex align-center justify-center items-center">
    <div class="container radius">
      <div class="title text-center">注册博客</div>
      <div class="item flex align-center justify-between items-center">
        <div class="label flex align-center justify-start items-center">账号：</div>
        <el-input v-model="user.username" placeholder="请输入账号"></el-input>
      </div>
      <div class="item flex align-center justify-between items-center">
        <div class="label flex align-center justify-start items-center">密码：</div>
        <el-input v-model="user.password" type="password" placeholder="请输入密码"></el-input>
      </div>
      <div class="item flex align-center justify-between items-center">
        <div class="label flex align-center justify-start items-center">昵称：</div>
        <el-input v-model="user.showName" placeholder="请输入昵称"></el-input>
      </div>
      <div class="item btns flex align-center justify-between items-center">
        <el-button @click="handleRegister" type="primary">注册</el-button>
        <el-button @click="handleReturn">返回</el-button>
      </div>
      <div class="info size-12 text-center"><a target="_blank" href="https://github.com/Enziandom/java-learning/tree/main/02-javaweb/experiments">About Source</a></div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { ElMessage } from "element-plus";
import service from "@/request";
import User from "@/entities/user";

const router = useRouter();
let user = ref(new User());

function handleRegister() {
  service
    .post("/register", user.value)
    .then(res => {
      if (res.data.length > 0) {
        ElMessage({
          center: true,
          message: `已经存在该账号！`,
          type: "error"
        });
      } else {
        ElMessage({
          center: true,
          message: `注册成功！`,
          type: "success"
        });
        setTimeout(() => {
          router.push("/login");
        }, 500);
      }
    })
    .catch(err => {
      ElMessage({
        center: true,
        message: `注册失败！`,
        type: "error"
      });
    });
}

function handleReturn() {
  router.push("/login");
}
</script>

<style scoped>
.register {
  width: 100%;
  height: 100%;
}

.label {
  width: 5vw;
}

.item,
.title {
  margin-bottom: 4vh;
}

.title {
  font-size: 22px;
}

.btns {
  padding: 0 6vw;
}

.container {
  padding: 4vh 4vw;
  width: 30vw;
  height: 50vh;
  box-sizing: border-box;
  background-color: var(--card-bg-color);
}
</style>
