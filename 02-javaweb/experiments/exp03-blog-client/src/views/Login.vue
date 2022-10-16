<template>
  <div class="login flex align-center justify-center items-center">
    <div class="container radius">
      <div class="title text-center">登录博客</div>
      <div class="item flex align-center justify-between items-center">
        <div class="label flex align-center justify-center items-center">账号：</div>
        <el-input v-model="user.username" placeholder="请输入账号"></el-input>
      </div>
      <div class="item flex align-center justify-between items-center">
        <div class="label flex align-center justify-center items-center">密码：</div>
        <el-input v-model="user.password" type="password" placeholder="请输入密码"></el-input>
      </div>
      <div class="item btns flex align-center justify-between items-center">
        <el-button @click="handleLogin" type="primary">登录</el-button>
        <el-button @click="handleRegister">注册</el-button>
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

function handleLogin() {
  service
    .post("/login", user.value, {
      withCredentials: true
    })
    .then(res => {
      let els = { message: "登陆失败", type: "error" };
      if (res.data.length > 0) {
        (els.message = "登陆成功"), (els.type = "success");
        setTimeout(() => {
          router.push("/h");
        }, 500);
      }
      ElMessage({
        center: true,
        message: els.message,
        type: els.type
      });
    })
    .catch(err => {});
}

function handleRegister() {}
</script>

<style scoped>
.login {
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
  height: 45vh;
  box-sizing: border-box;
  background-color: var(--card-bg-color);
}
</style>
