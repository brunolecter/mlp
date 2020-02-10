package com.mlp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mlp.model.Item;
import com.mlp.model.Lista;
import com.mlp.repository.ItemRepository;
import com.mlp.repository.ListaRepository;

@Controller
public class ListaController {
	
	//Injeção de dependência
	@Autowired
	public ListaRepository listarepository;

	//Injeção de dependência
	@Autowired
	public ItemRepository itemrepository;
	
	//Mapeamento da URL para cadastramento da Lista, quando o método é GET, ele busca por uma lista
	@RequestMapping(value="/cadastrar_lista", method=RequestMethod.GET)
	public String form() {
		return "cadastrar_lista";
	}
	
	//Mapeamento da URL para cadastramento da Lista, quando o método é POST, ele salva uma lista
	@RequestMapping(value="/cadastrar_lista", method=RequestMethod.POST)
	public String form(Lista lista) {
		listarepository.save(lista);
		return "redirect:/minhasListas/";
	}
	
	
	@Controller
	public class MinhasListas {
		@RequestMapping("/minhasListas")
		public ModelAndView todasLista() {
			ModelAndView objeto = new ModelAndView("minhasListas");
			Iterable<Lista> listas = listarepository.findAll();
			objeto.addObject("listas", listas);
			return objeto;
		}
	}
	
	@RequestMapping(value="/{codigoUnico}", method=RequestMethod.GET)
	public ModelAndView detalhesLista(@PathVariable("codigoUnico") String codigoUnico){
		Lista lista = listarepository.findByCodigoUnico(codigoUnico);
		ModelAndView dl = new ModelAndView("detalhesLista");
		dl.addObject("lista", lista);
		
		Iterable<Item> itens = itemrepository.findByLista(lista);
		dl.addObject("itens", itens);		
		return dl;
	}
	
	@RequestMapping("/deletarLista")
	public String deletarLista(String codigoUnico) {
		Lista lista = listarepository.findByCodigoUnico(codigoUnico);
		listarepository.delete(lista);
		return "redirect:/minhasListas";
	}
	
	@RequestMapping(value="/{codigoUnico}", method=RequestMethod.POST)
	public String detalhesListaPost(@PathVariable("codigoUnico") String codigoUnico, Item item){
		Lista lista = listarepository.findByCodigoUnico(codigoUnico);
		item.setLista(lista);
		itemrepository.save(item);
		return "redirect:/{codigoUnico}";
	}
	
	@RequestMapping("/deletarItem")
	public String deletarItem(long id) {
		Item item = itemrepository.findById(id);
		itemrepository.delete(item);
		
		Lista lista = item.getLista();
		String codigoLista = lista.getCodigoUnico();
		return "redirect:/" + codigoLista;
	}
	

}
