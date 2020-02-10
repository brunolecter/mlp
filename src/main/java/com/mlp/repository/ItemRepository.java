package com.mlp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlp.model.Item;
import com.mlp.model.Lista;

public interface ItemRepository extends JpaRepository<Item, String> {
	Iterable<Item> findByLista(Lista lista);
	Item findById(long id);
}
