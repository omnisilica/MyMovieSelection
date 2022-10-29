package com.omnisilica.mymovieselection.controller;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import com.omnisilica.mymovieselection.domain.*;
import com.omnisilica.mymovieselection.repository.MMSUserRepository;
import com.omnisilica.mymovieselection.service.*;

@Controller
public class LoginController {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	private final MMSUserRepository mmsUserRepository;
	
	UserService userService;
	
	public LoginController(MMSUserRepository mmsUserRepository) {
		this.mmsUserRepository = mmsUserRepository;}

	@GetMapping("/")
	String indexPageHandler() {
		return "index";
	}
	
	@GetMapping("/signup")
	String signUpHandler(Model model) {
		model.addAttribute("mmsUser", new MMSUser());
		return "signup";
	}
	
	@GetMapping("/login")
	String authenticateUserHandler() {
		return "login";
	}
	
	@GetMapping("/my_movies")
	String moviesDashboardHandler() {
		return "my_movies";
	}
	
	@PostMapping("/signup")
	String createMMSUserHandler(@Valid @ModelAttribute(value="mmsUser") MMSUser mmsUser, BindingResult bindingResult) {
		String view;
		
		if(bindingResult.hasErrors()) {
			view = "signup";
		} else {
			LOGGER.log(Level.INFO, mmsUser.getmmsUserEmail());
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(mmsUser.getmmsUserPassword());
			mmsUser.setmmsUserPassword(encodedPassword);

			mmsUserRepository.save(mmsUser);
		
			mmsUserRepository.save(mmsUser);
			view =  "index";
		}
		
		return view;
	}

}
