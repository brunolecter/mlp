package com.mlp.repository;

import org.springframework.data.repository.CrudRepository;

import com.mlp.model.Lista;

public interface ListaRepository extends CrudRepository<Lista, String>{
	Lista findByCodigoUnico(String codigoUnico);
}
