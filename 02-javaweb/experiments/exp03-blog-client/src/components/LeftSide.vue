<template>
  <div class="left-side hide-scroll">
    <img class="avatar cover radius" src="https://images-1303923190.cos.ap-chengdu.myqcloud.com/o_220930010815_90347759_p0.jpg" />
    <div class="info pad-b-15 border-b-dotted mar-t-10 size-13 flex justify-between align-center items-center">
      <div class="year">
        <div class="num text-center">21个月</div>
        <div class="text-center">园龄</div>
      </div>
      <div class="fans">
        <div class="num text-center">14</div>
        <div class="text-center">粉丝</div>
      </div>
      <div class="follows">
        <div class="num text-center">9</div>
        <div class="text-center">关注</div>
      </div>
    </div>
    <div class="tag-list">
      <h3 class="tip-title">我的标签</h3>
      <ul class="ul li-mar-tb-10 li-mar-tb-10-simp">
        <li>英语</li>
        <li>Excel</li>
        <li>Linux</li>
        <li>JavaScript</li>
        <li>HTML</li>
        <li>Node.js</li>
        <li>TypeScript</li>
      </ul>
    </div>
    <div class="post-list">
      <h3 class="tip-title">随笔分类</h3>
      <ul class="ul li-mar-tb-10 li-mar-tb-10-simp">
        <li>计算机网络</li>
        <li>计算机基础</li>
        <li>嵌入式系统开发</li>
        <li>数学</li>
        <li>操作系统</li>
        <li>移动应用开发</li>
        <li>数据库</li>
      </ul>
    </div>
  </div>
</template>
<script></script>
<style scoped>
.left-side {
  background-color: var(--card-bg-color);
  width: 12.5vw;
  padding: 15px;
  box-sizing: border-box;
}

.left-side .avatar {
  width: 100%;
  height: calc(12.5vw - 30px);
}
</style>
