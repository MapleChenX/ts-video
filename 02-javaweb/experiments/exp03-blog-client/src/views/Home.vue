<template>
  <div class="home">
    <BlogHeader :user="data[0]" />
    <div class="content flex justify-between">
      <LeftSide :user="data[0]" />
      <div class="views hide-scroll">
        <RouterView />
      </div>
      <RightSide />
    </div>
  </div>
</template>

<script setup>
import service from "@/request";
import { useCookies } from "@vueuse/integrations/useCookies";

const { data } = await service.post("/get/user", { id: useCookies().get("signed") });
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

.content {
  height: 91vh;
}
</style>
