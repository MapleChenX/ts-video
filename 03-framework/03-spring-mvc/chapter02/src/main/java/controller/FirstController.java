package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FirstController {

  @RequestMapping(value = "/fc1")
  public ModelAndView fc1(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ModelAndView mav = new ModelAndView();
    mav.addObject("msg", "这是我的第一个 Spring MVC 程序");
    mav.setViewName("first");
    return mav;
  }

  @RequestMapping(value = "/fc2")
  public String fc2(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    model.addAttribute("msg", "这是我的第一个 Spring MVC 程序");
    return "first";
  }


}