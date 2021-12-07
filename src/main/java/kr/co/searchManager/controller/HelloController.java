package kr.co.searchManager.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.searchManager.service.HelloService;

@Controller
public class HelloController {

	@Autowired
	HelloService helloService;
	
	@RequestMapping("/")
	public ModelAndView hello(HttpServletRequest request) {
		final HttpSession session = Optional.ofNullable(request).map(HttpServletRequest::getSession).orElse(null);
		ModelAndView mv = new ModelAndView("searchManager");	// tiles layout name
		return mv;
	}
	
		
}
