<script setup>
import { Setting, Guide, CaretRight } from "@element-plus/icons-vue";
import { useRouter } from "vue-router";

const router = useRouter();

function route(path) {
  router.push(path);
}

let item = JSON.parse(localStorage.getItem("user"));

function logout() {
  localStorage.setItem("user", "");
  route("/login");
}
</script>

<template>
  <el-container>
    <el-header class="flex justify-between align-center items-center">
      <div v-if="item.type === 'student'"
           class="flex align-center items-center">
        <el-avatar style="margin-right: 20px" :size="50" :src="item.avatar" />
        <div style="margin-right: 10px" class="flex align-center justify-between items-center">姓名：{{ item.name }}
        </div>
        <div style="margin-right: 10px" class="flex align-center justify-between items-center">学号：{{ item.sno }}</div>
        <div class="flex align-center justify-between items-center">上次登录：{{ item.loginDate }}</div>
      </div>
      <div v-if="item.type === 'teacher'"
           class="flex align-center items-center">
        <el-avatar style="margin-right: 20px" :size="50" :src="item.avatar" />
        <div style="margin-right: 10px" class="flex align-center justify-between items-center">姓名：{{ item.name }}
        </div>
        <div style="margin-right: 10px" class="flex align-center justify-between items-center">工号：{{ item.tno }}</div>
        <div class="flex align-center justify-between items-center">上次登录：{{ item.loginDate }}</div>
      </div>
      <el-button :icon="CaretRight" @click="logout">注销</el-button>
    </el-header>
    <el-container class="main">
      <el-aside>
        <el-scrollbar>
          <el-menu :default-openeds="['1']">
            <el-sub-menu index="1">
              <template #title>
                <el-icon>
                  <Guide />
                </el-icon>
                智能教学
              </template>
              <el-menu-item v-if="item.type !== 'teacher'" index="1-1" @click="route('/h/stu/course')">
                我的课程
              </el-menu-item>
              <el-menu-item v-if="item.type !== 'teacher'" index="1-2" @click="route('/h/stu/course/score')">
                课程成绩
              </el-menu-item>
              <el-menu-item v-if="item.type !== 'teacher'" index="1-3" @click="route('/h/stu/acts')">
                我的活动
              </el-menu-item>
              <el-menu-item v-if="item.type !== 'teacher'" index="1-4" @click="route('/h/stu/self')">
                我的信息
              </el-menu-item>
              <el-menu-item v-if="item.type !== 'student'" index="1-5" @click="route('/h/tch/course')">教的课程
              </el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="2">
              <template #title>
                <el-icon>
                  <setting />
                </el-icon>
                系统设置
              </template>
              <el-menu-item index="3-1">主题配置</el-menu-item>
            </el-sub-menu>
          </el-menu>
        </el-scrollbar>
      </el-aside>
      <el-main>
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<style>
.el-header {
  height: 10vh;
}

.main {
  height: 90vh;
  width: 100vw;
}

.is-vertical {
  height: 100vh;
  width: 100vw;
}
</style>

<style scoped lang="scss">
</style>