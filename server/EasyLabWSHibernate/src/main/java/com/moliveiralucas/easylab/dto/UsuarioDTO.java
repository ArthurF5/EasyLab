package com.moliveiralucas.easylab.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.moliveiralucas.easylab.domain.Usuario;

import org.hibernate.validator.constraints.Length;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 6376636789901540368L;

	private Integer id_Usuario;

	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 3, max = 20, message = "O campo deve conter entre 3 e 20 caracteres")
	private String usuario;

	@NotEmpty(message = "Preenchimento obrigatório!")
	@Email(message = "Email invalido!")
	@Length(min = 3, max = 100, message = "O campo deve conter entre 5 e 100 caracteres")
	private String email;

	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 3, max = 40, message = "O campo deve conter entre 3 e 40 caracteres")
	private String senha;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario obj) {
		id_Usuario = obj.getId_Usuario();
		usuario = obj.getUsuario();
		senha = obj.getSenha();
		email = obj.getEmail();
	}

	public Integer getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(Integer id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
