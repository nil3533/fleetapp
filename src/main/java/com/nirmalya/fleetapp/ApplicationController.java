package com.nirmalya.fleetapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationController {

	@GetMapping("/index")
	public String goHome() {
		System.out.println("abc");
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("login");
		return "login";
	}

	@GetMapping("/logout")
	public String logout() {
		return "login";
	}

	/*
	 * @RequestMapping(value = "/", method = RequestMethod.POST) public String
	 * postLogin(Model model, HttpSession session) { System.out.println("abclogin");
	 * UsernamePasswordAuthenticationToken authentication =
	 * (UsernamePasswordAuthenticationToken) SecurityContextHolder
	 * .getContext().getAuthentication();
	 * validatePrinciple(authentication.getPrincipal()); User loggedInUser =
	 * ((UserPrincipal) authentication.getPrincipal()).getUserDetails();
	 * model.addAttribute("currentUser", loggedInUser.getUsername());
	 * session.setAttribute("userId", loggedInUser.getId()); return "redirect:/"; }
	 * 
	 * private void validatePrinciple(Object principal) { if (!(principal instanceof
	 * UserPrincipal)) { throw new
	 * IllegalArgumentException("Principal can not be null!"); } }
	 */

}
