package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.*;
import com.example.demo.dao.UserRepo;


@Controller 
public class UserController {
	
	@Autowired
	com.exam.demo.dao.UserRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@PostMapping("/user")
	public String addUser(User user) {
		repo.save(user);
		return "home.jsp";
	}
	
	@RequestMapping("user")
	public ModelAndView getUser(@RequestParam int uid) {
		ModelAndView mv = new ModelAndView("showUser.jsp");
		User alien = repo.findById(uid).orElse(new User());
		mv.addObject(alien);
		return mv;
	}
	
	
	
}
