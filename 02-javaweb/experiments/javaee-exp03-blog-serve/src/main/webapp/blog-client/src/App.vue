<script setup>
import { RouterView } from "vue-router";
import BlogHeader from "./components/BlogHeader.vue";
import LeftSide from "./components/LeftSide.vue";
import RightSide from "./components/RightSide.vue";
</script>

<template>
  <Suspense>
    <div class="app flex col items-center">
      <div class="container">
        <BlogHeader />
        <div class="content flex justify-between">
          <LeftSide />
          <div class="views">
            <RouterView />
          </div>
          <RightSide />
        </div>
      </div>
    </div>
    <template #fallback> Loading... </template>
  </Suspense>
</template>

<style scoped>
.app {
  width: 100vw;
  height: 100vh;
}

.container {
  width: 65vw;
  height: 100vh;
}

.content {
  width: 100%;
  height: 91vh;
}

.views {
  box-sizing: border-box;
  background-color: var(--card-bg-color);
  width: 39vw;
}
</style>
