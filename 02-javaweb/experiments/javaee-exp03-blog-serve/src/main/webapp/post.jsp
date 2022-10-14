<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>文章页</title>
    <script src="https://code.jquery.com/jquery-3.6.1.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/layout.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/theme.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/pages/index.css" rel="stylesheet" />
  </head>
  <body class="flex row align-center justify-center items-center">
    <div class="container">
      <div class="include" file="${pageContext.request.contextPath}/module/header/index.html" css="${pageContext.request.contextPath}/module/header/index.css"></div>
      <div class="content flex row align-center justify-between">
        <div class="include" file="${pageContext.request.contextPath}/module/left-side/index.html" css="${pageContext.request.contextPath}/module/left-side/index.css" js="${pageContext.request.contextPath}/module/left-side/index.js"></div>
        <div class="include" file="${pageContext.request.contextPath}/module/post-detail/index.html" css="${pageContext.request.contextPath}/module/post-detail/index.css" js="${pageContext.request.contextPath}/module/post-detail/index.js"></div>
        <div class="include" file="${pageContext.request.contextPath}/module/right-side/index.html" css="${pageContext.request.contextPath}/module/right-side/index.css" js="${pageContext.request.contextPath}/module/right-side/index.js"></div>
      </div>
    </div>
  </body>
  <script src="${pageContext.request.contextPath}/config/index.js"></script>
  <script src="${pageContext.request.contextPath}/js/theme-helper.js"></script>
  <script src="${pageContext.request.contextPath}/utils/load-html.js"></script>
  <script src="${pageContext.request.contextPath}/utils/js-init.js"></script>
  <script src="${pageContext.request.contextPath}/utils/url-helper.js"></script>
</html>
