package com.mlp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mlp.model.lista;
import com.mlp.repository.ListaRepository;

@Controller
public class minhasListas {
	
	@Autowired
	private ListaRepository listarepository;
	
	@RequestMapping("/minhasListas")
	public ModelAndView todasLista() {
		ModelAndView objeto = new ModelAndView("minhasListas");
		Iterable<lista> listas = listarepository.findAll();
		objeto.addObject("listas", listas);
		return objeto;
	}
}

