axios
  .post("http://localhost:8080/blog-serve/get/posts")
  .then((res) => {
    for (let i = 0; i < res.data.length; i++) {
      // <div class="post-date">发表于${res.data[i]}</div>
      let template = `
        <div class="post-item mar-b-10 pad-all-10 border-b-dotted">
          <div class="post-title mar-b-10 size-18"><a href="./page/route/post?id=${res.data[i].id}">${res.data[i].title}</a></div>
          <div class="post-desc size-14">${res.data[i].desc}</div>
          <div class="view-post size-13 mar-tb-10"><a href="./page/route/post?id=${res.data[i].id}">阅读全文>></a></div>
          <div class="post-info flex justify-end size-13">
            <div class="post-date mar-r-10">发表于@${res.data[i].postDate}</div>
            <div class="post-thumbs mar-r-10">点赞(${res.data[i].thumbs})</div>
            <div class="post-views">阅读(${res.data[i].views})</div>
          </div>
        </div>
      `;
      $("#posts").append(template);
    }
  })
  .catch((err) => {});
