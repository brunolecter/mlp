package com.mlp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mlp.model.Item;
import com.mlp.model.Lista;
import com.mlp.repository.ItemRepository;
import com.mlp.repository.ListaRepository;

@Controller
public class ItemController {
	
	@Autowired
	public ItemRepository itemrepository;
	
	@Autowired
	public ListaRepository listarepository;
	
	@RequestMapping(value="/cadastrar_item")
	public String cadastrarItem() {
		return "cadastrar_item";
	}
	
	@Controller
	public class AllItem {
		@RequestMapping(value="/cadastrar_item", method=RequestMethod.GET)
		public ModelAndView todosItens() {
			ModelAndView item = new ModelAndView("cadastrar_item");
			Iterable<Item> itens = itemrepository.findAll();
			item.addObject("item", itens);
			return item;
		}
	}
	
	@RequestMapping(value="/cadastrar_item", method=RequestMethod.POST)
	public String form(String codigoUnico, Item item) {
		Lista lista = listarepository.findByCodigoUnico(codigoUnico);
		item.setLista(lista);
		itemrepository.save(item);
		return "index";
	}
	
	
}