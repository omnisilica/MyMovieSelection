package com.omnisilica.mymovieselection.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.omnisilica.mymovieselection.domain.*;
import com.omnisilica.mymovieselection.service.*;

@Controller
public class LoginController {
	
	UserService userService;
	
	public LoginController() {}

	@GetMapping("/")
	String indexPageHandler() {
		return "index";
	}
	
	@GetMapping("/signup")
	String signUpHandler() {
		return "signup";
	}

}
