<template>
  <div class="edit-profile pad-all-10">
    <div class="item text-center profile">个人信息</div>
    <div class="item flex align-center justify-between items-center">
      <div class="label flex align-center justify-start items-center">账号：</div>
      <el-input disabled v-model="user.username" show-word-limit maxlength="45" placeholder="请输入账号"></el-input>
    </div>
    <div class="item flex align-center justify-between items-center">
      <div class="label flex align-center justify-start items-center">昵称：</div>
      <el-input v-model="user.showName" show-word-limit maxlength="45" placeholder="请输入昵称"></el-input>
    </div>
    <div class="item flex align-center justify-between items-center">
      <div class="label flex align-center justify-start items-center">密码：</div>
      <el-input v-model="user.password" show-word-limit maxlength="45" placeholder="请输入密码"></el-input>
    </div>
    <div class="item flex align-center justify-between items-center">
      <div class="label flex align-center justify-start items-center">性别：</div>
      <el-input v-model="user.sex" show-word-limit maxlength="2" placeholder="请输入性别"></el-input>
    </div>
    <div class="item flex align-center justify-between items-center">
      <div class="label flex align-center justify-start items-center">年龄：</div>
      <el-input v-model="user.age" show-word-limit maxlength="3" placeholder="请输入年龄"></el-input>
    </div>
    <div class="item flex align-center justify-between items-center">
      <div class="label flex align-center justify-start items-center">头像地址：</div>
      <el-input v-model="user.avatar" show-word-limit maxlength="255" placeholder="请输入网络地址：URL"></el-input>
    </div>
    <div class="item flex align-center justify-between items-center">
      <div class="label flex align-center justify-start items-center">个性签名：</div>
      <el-input type="textarea" autosize show-word-limit maxlength="50" v-model="user.signature" placeholder="请输入个性签名"></el-input>
    </div>
    <div class="item flex align-center justify-end">
      <el-button @click="updateProfile" type="primary">更新信息</el-button>
    </div>
  </div>
</template>

<script setup>
import service from "@/request";
import User from "@/entities/user";
import { ref, inject } from "vue";
import { useCookies } from "@vueuse/integrations/useCookies";

let user = ref(new User());
user.value = inject("user");
console.log(user.value);
user.value.id = useCookies().get("signed");

function updateProfile() {
  service.post("/update/user", user.value);
}
</script>

<style scoped>
.profile {
  font-size: 22px;
}

.label {
  width: 8vw;
}

.item {
  margin-bottom: 20px;
}
</style>
