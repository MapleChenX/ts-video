<template>
  <div class="post pad-all-10">
    <div class="title">{{ post.title }}</div>
    <div class="info flex justify-end size-14">
      <div class="post-date mar-r-10">发表于：{{ post.postDate }}</div>
      <div class="views mar-r-10">阅读：{{ post.views }}</div>
      <div class="views">点赞：{{ post.thumbs }}</div>
    </div>
    <div class="content">{{ post.content }}</div>
  </div>
</template>

<script setup>
import service from "../request";
import { useRoute } from "vue-router";

const route = useRoute();

let id = route.query.id;

const { data } = await service.post(`/get/post?id=${id}`);
let post = data[0];
</script>

<style scoped>
.title {
  font-size: 22px;
}

.title,
.post-date {
  margin-bottom: 20px;
}
</style>
