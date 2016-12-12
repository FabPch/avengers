package org.shield.avengers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

	
	@RequestMapping(method=RequestMethod.GET)
	public String index() {
		
		return "index";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list() {
		
		return "list";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String indexPost() {
		
		return "index2";
	}
}
