package com.lojadegames.lojadegames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuarios")
public class UsuarioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O  nome é obrigatório!")
	private String nome;

	@NotNull(message = "O usuário é obrigatório!")
	@Email(message = "O usuário deve ser um email válido!")
	private String usuario;

	@NotBlank(message = "A senha é obrigatória!")
	@Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
	private String senha;

	@Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres")
	private String foto;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<ProdutoModel> produto;
	
	


	public Long getId() {
		return id;
}




	public String getUsuario() {
		// TODO Auto-generated method stub
		return null;
	}




	public String getSenha() {
		// TODO Auto-generated method stub
		return null;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getFoto() {
		return foto;
	}




	public void setFoto(String foto) {
		this.foto = foto;
	}




	public List<ProdutoModel> getProduto() {
		return produto;
	}




	public void setProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}
}