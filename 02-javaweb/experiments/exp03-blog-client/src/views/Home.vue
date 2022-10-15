<template>
  <div class="home hide-scroll flex justify-between">
    <LeftSide />
    <div class="views hide-scroll">
      <RouterView />
    </div>
    <RightSide />
  </div>
</template>

<script setup>
import service from "@/request";

const { data } = await service.post("/get/posts");
</script>

<style scoped>
.home {
  box-sizing: border-box;
}

.views {
  box-sizing: border-box;
  background-color: var(--card-bg-color);
  width: 39vw;
}
</style>
