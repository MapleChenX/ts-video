<template>
  <div class="new-post pad-all-10">
    <div class="title flex align-center items-center justify-between">
      <div class="label size-17">标题：</div>
      <el-input maxlength="50" show-word-limit v-model="post.title" placeholder="请输入文章标题"></el-input>
    </div>
    <Editor class="editor" :value="post.content" @change="handleChange" />
    <div class="desc flex align-center items-start justify-between">
      <div class="label size-17">摘要：</div>
      <el-input maxlength="200" show-word-limit :rows="4" type="textarea" v-model="post.desc" placeholder="请输入文章摘要"></el-input>
    </div>
    <div class="btn flex align-center items-center justify-end">
      <el-button type="primary" @click="submit">发表文章</el-button>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import service from "@/request";
import { Editor } from "@bytemd/vue-next";
import Post from "@/entities/post.js";

let post = ref(new Post());

function handleChange(newValue) {
  post.value.content = newValue;
}

function submit() {
  service.post(`/insert/post`, post.value);
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
