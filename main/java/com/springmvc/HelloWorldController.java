package com.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//method to show the form 
	@RequestMapping("/showform")
	public String showForm(){
		return "helloworld-form";
	}
	
	//method to show the result from the form
	@RequestMapping("/processform")
	public String processForm() {
		return "helloworld";
	}
	
	//method to read form data and add to it to the model
	@RequestMapping("/processFormTwo")
	public String letsShout(HttpServletRequest request, Model model) {
		//read request parameter from html form
		String name = request.getParameter("studentName");
		
		//convert to uppercase
		name = name.toUpperCase();
		
		//create message
		String message = "Yo " + name;
		
		//add message to the model
		model.addAttribute("message", message);
		
		return "helloworld";
	}
	
	@RequestMapping("processFormThree")
	public String processFormThree(
			@RequestParam("studentName") String name,
			Model model) {
		
		//convert to uppercase
		name = name.toUpperCase();
		
		//create message
		String message = "Yo " + name;
		
		//add message to the model
		model.addAttribute("message", message);
		
		return "helloworld";
	}
}
