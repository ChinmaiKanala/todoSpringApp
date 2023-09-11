package com.version_4.springboot.myfirstspringapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

//	private AuthenticationService authenticationService;
//	
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String goToWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	
	
	
//	@RequestMapping(value = "login",method = RequestMethod.POST)
//	public String goToWelcome(@RequestParam String name, @RequestParam String password, ModelMap map) {
//		
//		if(authenticationService.authenticate(name, password)) {
//		
//			map.put("name", name);
//			map.put("password", password);
//			
//			return "welcome";
//		
//		}
//		
//	    map.put("errorMessage", "Invalid Credentials");
//		return "login";
//	}
	
	
	
}
