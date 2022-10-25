Servlet + JDBC 做一个前后端交互的功能，可以实现简单的登录、注册。

登录成功通过 getRequestDispatcher 跳转其他页面，而这种方式能够把本 Servlet 的东西转存到另一个 JSP 页面中；

sendRedirect 只是一个页面跳转功能，而且会改变 URL 地址，不可以传递数据到其他 JSP 页面。