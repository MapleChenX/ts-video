<template>
  <div class="posts pad-all-10">
    <div class="content">
      <template v-if="data.length > 0" v-for="item in data">
        <div class="post-item mar-b-10 pad-b-10 border-b-dotted">
          <div class="post-title mar-b-10 size-18">
            <router-link :to="{ path: '/h/post', query: { id: item.id } }">
              {{ item.title }}
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
      </template>
      <template v-else>
        <div class="no-data flex align-center items-center justify-center">
          <div class="flex col align-center items-center justify-center">
            <div class="size-19 mar-b-10">你没有发表任何一篇文章</div>
            <div class="size-19 mar-b-10">赶紧去发表一篇吧！</div>
            <div class="size-15 mar-b-10"><router-link to="/h/new/post">👉发表文章</router-link></div>
            <div class="size-12 tips mar-b-5">The Blog System was Powered By ZhengRenFu</div>
            <div class="size-12 tips">Here was Blog System Source At <a href="https://github.com/Enziandom/java-learning/tree/main/02-javaweb/experiments">GitHub</a></div>
          </div>
        </div>
      </template>
    </div>
  </div>
</template>

<script setup>
import service from "@/request";
import { useCookies } from "@vueuse/integrations/useCookies";

const { data } = await service.post("/get/posts", { id: useCookies().get("signed") });
</script>

<style scoped>
.no-data {
  width: 39vw;
  height: 91vh;
}
</style>
