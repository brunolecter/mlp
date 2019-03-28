package com.mlp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lista implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codigo;
	
	private String nome;
	private String data_fim;
	public String codigo_unico;
	
	
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData_fim() {
		return data_fim;
	}
	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}
	public String getCodigo_unico() {
		return codigo_unico;
	}
	public void setCodigo_unico(String codigo_unico) {
		this.codigo_unico = codigo_unico;
	}
	
	
}
