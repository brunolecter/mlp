package com.mlp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mlp.model.usuario;
import com.mlp.repository.UsuarioRepository;

@Controller
public class usuarioController {
	
	//Injeção de dependência
	@Autowired
	private UsuarioRepository usuariorepository;
	
	@RequestMapping("/cadastrar_usuario")
	public String cadastrar_usuario() {
		return "cadastrar_usuario";
	}
	
	@RequestMapping(value="/cadastrar_usuario", method=RequestMethod.POST)
	public String form(usuario usuario) {
		
		//Salvando lista no banco de dados
		usuariorepository.save(usuario);
		
		return "redirect:/cadastrar_lista";
	}
}


