<template>
  <div class="edit pad-all-10">
    <div class="title flex align-center items-center justify-between">
      <div class="label size-17">标题：</div>
      <el-input maxlength="50" show-word-limit v-model="post.title" placeholder="请输入文章标题"></el-input>
    </div>
    <Editor class="editor" :value="post.content" @change="handleChange" />
    <div class="desc flex align-center items-start justify-between">
      <div class="label size-17">摘要：</div>
      <el-input maxlength="200" show-word-limit :rows="4" type="textarea" v-model="post.desc" placeholder="请输入文章摘要"></el-input>
    </div>
    <div class="info size-13">
      <div class="date mar-b-10 flex justify-end align-center items-center">
        <div class="create-date mar-r-10">发表日期：{{ post.createDate }}</div>
        <div class="post-date">最近修改：{{ post.postDate }}</div>
      </div>
      <div class="belong-to text-end">文章ID：{{ post.id }}</div>
    </div>
    <div class="btn flex align-center items-center justify-end">
      <el-button type="primary" @click="submit">更新文章</el-button>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import service from "@/request";
import { useRoute, useRouter } from "vue-router";
import { Editor } from "@bytemd/vue-next";
import { ElMessageBox, ElMessage } from "element-plus";

const route = useRoute();
const router = useRouter();

let { data } = await service.post(`/get/post?id=${route.query.id}`);
let post = ref(data[0]);

function handleChange(newValue) {
  post.value.content = newValue;
}

function submit() {
  ElMessageBox.confirm("确定更新该文章？", "提示", {
    cancelButtonText: "取消",
    confirmButtonText: "确定"
  })
    .then(() => {
      service.post(`/update/post`, post.value);
      ElMessage({
        center: true,
        message: `更新成功！`,
        type: "success"
      });
      setTimeout(() => {
        router.push("/h/posts");
      }, 500);
    })
    .catch(() => {
      ElMessage({
        center: true,
        message: `更新失败！`,
        type: "error"
      });
    });
}
</script>

<style scoped>
.label {
  width: 11%;
}

.title,
.editor,
.desc,
.info {
  margin-bottom: 20px;
}
</style>
