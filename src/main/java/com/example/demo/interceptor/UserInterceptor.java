package com.example.demo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class UserInterceptor implements HandlerInterceptor {

  /**
   * 请求进入controller之前的拦截操作
   *
   * @param request 请求
   * @param response 响应
   * @param handler handler
   * @return 是否拦截
   * @throws Exception 异常
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    log.info("进入拦截器，本次请求的url为：{}", request.getRequestURL());

    String username = request.getParameter("username");
    if ("qxf".equals(username)) {
      return true;
    }

    // 如果登陆用户名不是qxf，那么在此处理异常逻辑
    handleFalseResponse(response);

    return false;
  }

  private void handleFalseResponse(HttpServletResponse response) throws IOException {
    response.setStatus(200);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write("请求失败");
    response.getWriter().flush();
  }
}
