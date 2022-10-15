package filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet 拦截器，拦截所有 URL，解决跨域问题。
 *
 * @author zhengrenfu
 * @version 1.0
 * @since 1.5
 */
@WebFilter(filterName = "CrossOriginFilter", urlPatterns = "/*")
public class CrossOriginFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    Filter.super.init(filterConfig);
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    servletRequest.setCharacterEncoding("UTF-8");
    servletResponse.setCharacterEncoding("UTF-8");
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    // 允许跨域的主机地址
    response.setHeader("Access-Control-Allow-Origin", "*");
    // 允许跨域的请求方法 GET、POST、HEAD 等
    response.setHeader("Access-Control-Allow-Methods", "*");
    // 重新预检验跨域的缓存时间 (s)
    response.setHeader("Access-Control-Max-Age", "3600");
    // 允许跨域的请求头
    response.setHeader("Access-Control-Allow-Headers", "*");
    // 是否携带 Cookie
    response.setHeader("Access-Control-Allow-Credentials", "true");
    filterChain.doFilter(servletRequest, response);
  }

  @Override
  public void destroy() {
    Filter.super.destroy();
  }
}
