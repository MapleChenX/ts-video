<script setup></script>

<template>
  <Suspense>
    <div class="app flex col items-center">
      <div class="container hide-scroll">
        <RouterView />
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
</style>
