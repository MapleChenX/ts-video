package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstController implements Controller {

  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ModelAndView mav = new ModelAndView();
    mav.addObject("msg", "这是我的第一个 MVC 程序");
    mav.setViewName("/WEB-INF/jsp/first.jsp");
    return mav;
  }

}