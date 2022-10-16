<template>
  <div class="post pad-all-10">
    <div class="title">{{ post.title }}</div>
    <div class="info flex justify-end items-center size-13">
      <div class="post-date mar-r-10">发表时间：{{ post.createDate }}</div>
      <div class="views mar-r-10">阅读：{{ post.views }}</div>
      <div class="thumbs mar-r-10">点赞：{{ post.thumbs }}</div>
      <template v-if="post.userId === id">
        <el-button size="small" @click="editPost" type="primary" :icon="Edit" circle plain />
      </template>
    </div>
    <div class="content">{{ post.content }}</div>
    <div class="footer">
      <div class="info flex justify-end size-13">
        <div class="post-date mar-r-10">最近修改：{{ post.postDate }}</div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { Edit } from "@element-plus/icons-vue";
import service from "@/request";
import { useRoute, useRouter } from "vue-router";
import { useCookies } from "@vueuse/integrations/useCookies";

const id = useCookies().get("signed");
const route = useRoute();
const router = useRouter();

const { data } = await service.post(`/get/post?id=${route.query.id}`);
let post = ref(data[0]);

function editPost() {
  router.push({ path: "/h/edit", query: { id: route.query.id } });
}
</script>

<style scoped>
.title {
  font-size: 22px;
}

.info {
  margin-top: 20px;
  margin-bottom: 18px;
}
</style>
