<template>
  <div class="home pad-all-10">
    <div class="posts">
      <div v-for="item in data" class="post-item mar-b-10 border-b-dotted pad-b-10">
        <div class="post-title mar-b-10 size-18">
          <router-link :to="{ path: '/post', query: { id: item.id } }">
            {{ item.title }}
          </router-link>
        </div>
        <div class="post-desc size-14">{{ item.desc }}</div>
        <div class="view-post size-13 mar-tb-10">
          <router-link :to="{ path: '/post', query: { id: item.id } }"> 阅读全文>> </router-link>
        </div>
        <div class="post-info flex justify-end size-13">
          <div class="post-date mar-r-10">发表于@{{ item.postDate }}</div>
          <div class="post-thumbs mar-r-10">点赞({{ item.thumbs }})</div>
          <div class="post-views">阅读({{ item.views }})</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import service from "@/request";

const { data } = await service.post("/get/posts");
</script>

<style scoped></style>
