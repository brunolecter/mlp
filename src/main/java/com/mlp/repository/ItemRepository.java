package com.mlp.repository;

import org.springframework.data.repository.CrudRepository;

import com.mlp.model.Item;
import com.mlp.model.Lista;

public interface ItemRepository extends CrudRepository<Item, String> {
	Iterable<Item> findByLista(Lista lista);
	Item findById(long id);
}
