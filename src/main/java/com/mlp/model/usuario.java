package com.mlp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class usuario implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long usuario_codigo;
	
	private String usuario_nome;
	private String usuario_email;
	private String usuario_senha;
	
	public long getUsuario_codigo() {
		return usuario_codigo;
	}
	public void setUsuario_codigo(long usuario_codigo) {
		this.usuario_codigo = usuario_codigo;
	}
	public String getUsuario_nome() {
		return usuario_nome;
	}
	public void setUsuario_nome(String usuario_nome) {
		this.usuario_nome = usuario_nome;
	}
	public String getUsuario_email() {
		return usuario_email;
	}
	public void setUsuario_email(String usuario_email) {
		this.usuario_email = usuario_email;
	}
	public String getUsuario_senha() {
		return usuario_senha;
	}
	public void setUsuario_senha(String usuario_senha) {
		this.usuario_senha = usuario_senha;
	}
	

	
	

}
