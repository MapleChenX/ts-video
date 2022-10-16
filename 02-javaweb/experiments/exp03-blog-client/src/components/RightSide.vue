<template>
  <div class="right-side hide-scroll pad-all-15">
    <div>
      <h3 class="tip-title" style="margin-top: 0 !important">常用链接</h3>
      <ul class="links-wrap ul li-mar-tb-10 li-mar-tb-10-simp">
        <li class="links item-0">
          <a href="http://www.cyc2018.xyz/" target="_blank"> CS-Notes </a>
        </li>
        <li class="links item-1">
          <a href="https://qishaoxuan.github.io/css_tricks/" target="_blank"> CSS Tricks </a>
        </li>
        <li class="links item-2">
          <a href="https://zh.javascript.info/" target="_blank"> 现代 JavaScript 教程 </a>
        </li>
        <li class="links item-3">
          <a href="https://ts.yayujs.com/" target="_blank"> TypeScript中文文档 </a>
        </li>
        <li class="links item-4">
          <a href="https://cn.vuejs.org/" target="_blank"> Vue3 </a>
        </li>
        <li class="links item-5">
          <a href="https://router.vuejs.org/zh/" target="_blank"> VueRouter </a>
        </li>
        <li class="links item-6">
          <a href="https://vueuse.org/" target="_blank"> VueUse </a>
        </li>
      </ul>
    </div>
    <div>
      <h3 class="tip-title">推荐书籍</h3>
      <ul class="books-wrap size-13 ul li-mar-tb-10 li-mar-tb-10-simp">
        <li class="books item-0">
          <div class="wrap flex">
            <img alt="book-cover" class="cover" src="https://img14.360buyimg.com/pop/jfs/t4486/22/2963159037/231195/fdc77649/58f4973fN505dc407.jpg" />
            <div class="info">
              <div class="title">深入理解 JavaScript</div>
              <div class="author">罗彻麦尔</div>
            </div>
          </div>
        </li>
        <li class="books item-1">
          <div class="wrap flex">
            <img alt="book-cover" class="cover" src="http://t13.baidu.com/it/u=786607696,850340445&amp;fm=224&amp;app=112&amp;f=JPEG?w=375&amp;h=500" />
            <div class="info">
              <div class="title">JavaScript 权威指南</div>
              <div class="author">弗拉纳根</div>
            </div>
          </div>
        </li>
        <li class="books item-2">
          <div class="wrap flex">
            <img alt="book-cover" class="cover" src="http://t15.baidu.com/it/u=1106356188,2043144488&amp;fm=224&amp;app=112&amp;f=JPEG?w=276&amp;h=387" />
            <div class="info">
              <div class="title">大学计算机基础与计算思维</div>
              <div class="author">史巧硕，柴欣</div>
            </div>
          </div>
        </li>
        <li class="books item-2">
          <div class="wrap flex">
            <img alt="book-cover" class="cover" src="http://t15.baidu.com/it/u=1106356188,2043144488&amp;fm=224&amp;app=112&amp;f=JPEG?w=276&amp;h=387" />
            <div class="info">
              <div class="title">大学计算机基础与计算思维</div>
              <div class="author">史巧硕，柴欣</div>
            </div>
          </div>
        </li>
        <li class="books item-2">
          <div class="wrap flex">
            <img alt="book-cover" class="cover" src="http://t15.baidu.com/it/u=1106356188,2043144488&amp;fm=224&amp;app=112&amp;f=JPEG?w=276&amp;h=387" />
            <div class="info">
              <div class="title">大学计算机基础与计算思维</div>
              <div class="author">史巧硕，柴欣</div>
            </div>
          </div>
        </li>
        <li class="books item-2">
          <div class="wrap flex">
            <img alt="book-cover" class="cover" src="http://t15.baidu.com/it/u=1106356188,2043144488&amp;fm=224&amp;app=112&amp;f=JPEG?w=276&amp;h=387" />
            <div class="info">
              <div class="title">大学计算机基础与计算思维</div>
              <div class="author">史巧硕，柴欣</div>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>
<script></script>
<style scoped>
.right-side {
  background-color: var(--card-bg-color);
  width: 12.5vw;
  box-sizing: border-box;
}

.cover {
  width: 3vw;
  height: 7vh;
  object-fit: contain;
}

.info {
  word-wrap: break-word;
}

.wrap {
  justify-content: space-between;
}

.books {
  flex-wrap: wrap;
}
</style>
