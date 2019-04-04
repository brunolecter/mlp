package com.mlp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mlp.model.Lista;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("lista", new Lista());
		return "index";
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String form(Lista lista) {
		return "redirect:/"+ lista.getCodigoUnico();
	}
}
