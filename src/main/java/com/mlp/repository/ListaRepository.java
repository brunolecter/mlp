package com.mlp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlp.model.Lista;

public interface ListaRepository extends JpaRepository<Lista, String>{
	Lista findByCodigoUnico(String codigoUnico);
}
