package com.test.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	
	public ModelAndView hello(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("spring","spring mvc");
		mv.setViewName("helloPage");
		return mv;
	}
	
	@RequestMapping("/testUTF8")
	
	public ModelAndView testmvc(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("testChinese", "ok,成功了！");
		mv.setViewName("testChinesePage");
		return mv;
	}
}
