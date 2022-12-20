<script setup>
import { ref } from "vue";

let user = ref({ username: "", password: "" });

function handleLogin() {

}

function handleRegister() {

}
</script>

<template>
  <div class="login flex align-center justify-center items-center">
    <div class="container radius">
      <div class="title text-center">登录系统</div>
      <div class="item flex align-center justify-between items-center">
        <div class="label flex align-center justify-start items-center">账号：</div>
        <el-input v-model="user.username" placeholder="请输入账号"></el-input>
      </div>
      <div class="item flex align-center justify-between items-center">
        <div class="label flex align-center justify-start items-center">密码：</div>
        <el-input v-model="user.password" type="password" placeholder="请输入密码"></el-input>
      </div>
      <div class="item btns flex align-center justify-between items-center">
        <el-button @click="handleLogin" type="primary">登录</el-button>
        <el-button @click="handleRegister">注册</el-button>
      </div>
    </div>
  </div>
</template>

<style scoped lang="css">
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
  height: 50vh;
  box-sizing: border-box;
}
</style>