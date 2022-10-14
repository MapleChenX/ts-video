function loadHTML() {
  $(".include").each(function () {
    if (!!$(this).attr("css")) {
      let $includeObj = $(this);
      $(this).load($(this).attr("css"), function (html) {
        $includeObj.after(`<style rel="stylesheet">${html}</style>`);
      });
    }
    if (!!$(this).attr("js")) {
      let $includeObj = $(this);
      $(this).load($(this).attr("js"), function (html) {
        $includeObj.after(`<script>${html}</script>`);
      });
    }
    if (!!$(this).attr("file")) {
      let $includeObj = $(this);
      $(this).load($(this).attr("file"), function (html) {
        // 加载的文件内容写入到当前标签后面并移除当前标签
        $includeObj.after(html).remove();
      });
    }
  });
}
