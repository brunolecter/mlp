package com.mlp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Lista implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	public String nome;
	public String dataFim;
	public String nomeAnfitriao;

	
	public String getNomeAnfitriao() {
		return nomeAnfitriao;
	}

	public void setNomeAnfitriao(String nomeAnfitriao) {
		this.nomeAnfitriao = nomeAnfitriao;
	}

	@Id
	public String codigoUnico;
	
	@OneToMany(mappedBy="lista", orphanRemoval=true, cascade=CascadeType.ALL)
	private List<Item> itens;

	
	public Lista() {
		this.codigoUnico = Utils.codigo();
	}
		
	public Lista(String nome, String dataFim) {
		super();
		this.nome = nome;
		this.dataFim = dataFim;
	}
	
	public String getCodigoUnico() {
		return codigoUnico;
	}

	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

}