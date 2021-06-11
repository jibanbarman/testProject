package com.jiban.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jiban.dao.UserJDBCRepository;
import com.jiban.model.User;

@Controller
public class MvcController {
	
	@Autowired
	private UserJDBCRepository userRepository;

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/register")
	public String showForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		
		List<String> professionList = Arrays.asList("Developer","Tester","HR","Manager","Architect");
		model.addAttribute("professionList",professionList);
		
		return "registration_form";
	}
	
	@PostMapping("/register")
	public String submitForm(@ModelAttribute("user")User user,ModelMap model) {
		
	try {
		if(userRepository.findByEmail(user.getEmail()) !=null) {
				model.put("message", "You are already in database");
				return "registration_form";	
		}
	}catch(Exception e) {	
	}
	
	int row=userRepository.insert(user);
	System.out.println(row +" record has been added");
	return "register_success";
	}
}
