<template>
  <div class="sqaure pad-all-10">
    <div v-for="item in data" class="post-item mar-b-10 pad-b-10 border-b-dotted">
      <div class="post-title mar-b-10 size-18">
        <router-link :to="{ path: '/h/post', query: { id: item.id } }">
          {{ item.title }}
          <el-tag v-if="item.userId === id">我的</el-tag>
        </router-link>
      </div>
      <div class="post-desc size-14">{{ item.desc }}</div>
      <div class="view-post size-13 mar-tb-10">
        <router-link :to="{ path: '/h/post', query: { id: item.id } }"> 阅读全文>> </router-link>
      </div>
      <div class="post-info flex justify-end size-13">
        <div class="post-date mar-r-10">发表于@{{ item.createDate }}</div>
        <div class="post-thumbs mar-r-10">点赞({{ item.thumbs }})</div>
        <div class="post-views">阅读({{ item.views }})</div>
      </div>
    </div>
  </div>
</template>

<script setup>
import service from "@/request";
import { useCookies } from "@vueuse/integrations/useCookies";

const id = useCookies().get("signed");

const { data } = await service.post("/get/all/posts");
</script>

<style scoped></style>
