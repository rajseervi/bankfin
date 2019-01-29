package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import com.app.model.User; 
import com.app.service.IUserService;

@Controller 
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;
	 
	@RequestMapping("/reg")
	public String showUserRegPage(ModelMap map) {
		map.addAttribute("user", new User ());
		return "UserRegister";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST) 
	public String saveEmp(@ModelAttribute("user")User user,ModelMap map ) {
		int n= service.saveUser(user); 
		if(n>0) {
			System.out.println("user added :"+n);
			map.addAttribute("user", new User()); 
			map.addAttribute("msg","User Added Successfully with serial:"+n);
		}
		
		return "UserRegister";
	} 
}
