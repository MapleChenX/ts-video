<script setup>
import { ref } from "vue";
import axios from "axios";
import { ElMessage } from "element-plus";
import { useRouter } from "vue-router";

let user = ref({ account: "", password: "" });
const router = useRouter();
let radio = ref("1");

function handleLogin() {
  if (radio.value === "1") {
    axios.post(
      "http://localhost:8080/entries/stu/login",
      {
        account: user.value.account,
        password: user.value.password
      }
    ).then(({ data }) => {
      if (data.code === 200) {
        ElMessage({
          message: "登录成功！",
          grouping: true,
          type: "success"
        });
        data.data["type"] = "student";
        localStorage.setItem("user", JSON.stringify(data.data));
        router.push("/h/stu/course");
      } else {
        ElMessage({
          message: data.data,
          grouping: true,
          type: "error"
        });
      }
    });
  } else {
    axios.post(
      "http://localhost:8080/entries/tch/login",
      {
        account: user.value.account,
        password: user.value.password
      }
    ).then(({ data }) => {
      if (data.code === 200) {
        ElMessage({
          message: "登录成功！",
          grouping: true,
          type: "success"
        });
        data.data["type"] = "teacher";
        localStorage.setItem("user", JSON.stringify(data.data));
        router.push("/h/tch/course");
      } else {
        ElMessage({
          message: data.data,
          grouping: true,
          type: "error"
        });
      }
    });
  }
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
        <el-input v-model="user.account" placeholder="请输入账号"></el-input>
      </div>
      <div class="item flex align-center justify-between items-center">
        <div class="label flex align-center justify-start items-center">密码：</div>
        <el-input v-model="user.password" type="password" placeholder="请输入密码"></el-input>
      </div>
      <div class="item flex align-center justify-between items-center">
        <el-radio-group v-model="radio">
          <el-radio label="1" size="small">学生登录</el-radio>
          <el-radio label="7" size="small">教师登录</el-radio>
        </el-radio-group>
      </div>
      <div class="item bottom">
        <div>
          <el-button @click="handleLogin" type="primary">登录</el-button>
        </div>
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

.container {
  padding: 4vh 4vw;
  width: 30vw;
  height: 50vh;
  box-sizing: border-box;
}

.bottom {
  display: flex;
  align-content: center;
  justify-content: center;
  align-items: center;
}
</style>