package com.mlp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mlp.model.Lista;
import com.mlp.repository.ListaRepository;


@Controller
public class IndexController {
	
	@Autowired
	public ListaRepository listarepository;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("lista", new Lista());
		return "index";
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String form(String obj) {
		return "redirect:/"+ obj;
	}
}
