package com.mlp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mlp.model.lista;
import com.mlp.repository.ListaRepository;

@Controller
public class listaController {
	
	//Injeção de dependência
	@Autowired
	private ListaRepository listarepository;
	
	@RequestMapping(value="/cadastrar_lista", method=RequestMethod.GET)
	public String form() {
		return "formLista";
	}
	
	public String codigo() {
		String[] carct ={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

	    String codigo_unico="";

	    for (int x=0; x<4; x++){
	        int j = (int) (Math.random()*carct.length);
	        codigo_unico += carct[j];
	    }
	    return codigo_unico;
	}
	
	
	@RequestMapping(value="/cadastrar_lista", method=RequestMethod.POST)
	public String form(lista lista) {
		
		lista.codigo_unico = codigo();
		
		//Salvando lista no banco de dados
		listarepository.save(lista);
		
		return "redirect:/minhasListas";
	}
	

}
