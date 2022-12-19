<script setup>
import { Menu as IconMenu, Setting, Guide } from "@element-plus/icons-vue";
</script>

<template>
  <el-container>
    <el-header>Header</el-header>
    <el-container class="main">
      <el-aside>
        <el-scrollbar>
          <el-menu :default-openeds="['1', '2']">
            <el-sub-menu index="1">
              <template #title>
                <el-icon>
                  <Guide />
                </el-icon>
                智能教学
              </template>
              <el-menu-item index="1-1">我的课程</el-menu-item>
              <el-menu-item index="1-2">课程成绩</el-menu-item>
              <el-menu-item index="1-3">我的信息</el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="2">
              <template #title>
                <el-icon>
                  <icon-menu />
                </el-icon>
                学工业务
              </template>
              <el-menu-item index="2-1">我的素拓</el-menu-item>
              <el-menu-item index="2-2">我的二课</el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="3">
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

<style scoped>
</style>
