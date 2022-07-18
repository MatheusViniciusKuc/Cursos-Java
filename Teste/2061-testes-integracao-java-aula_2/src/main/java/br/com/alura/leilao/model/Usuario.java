package br.com.alura.leilao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@NotNull
	@NotBlank
	@Column(name = "username")
	private String nome;

	@NotNull
	@NotBlank
	@Column(name = "password")
	private String senha;

	@NotNull
	@NotBlank
	@Email
	private String email;

	// Srpign Security
	private String role;
	private boolean enabled;

	@Deprecated
	public Usuario() {
	}

	public Usuario(@NotNull @NotBlank String nome) {
		this.nome = nome;
	}

	public Usuario(@NotNull @NotBlank String nome, @NotNull @NotBlank @Email String email, @NotNull @NotBlank String password) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = password;
	}

	
	/** 
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	
	/** 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	
	/** 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	/** 
	 * @return String
	 */
	public String getNome() {
		return nome;
	}

	
	/** 
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	
	/** 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	/** 
	 * @return String
	 */
	public String getRole() {
		return role;
	}

	
	/** 
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	
	/** 
	 * @return boolean
	 */
	public boolean isEnabled() {
		return enabled;
	}

	
	/** 
	 * @param enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
	/** 
	 * @return String
	 */
	public String getSenha() {
		return this.senha;
	}

	
	/** 
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void activa() {
		this.enabled = true;
	}

	public void desativa() {
		this.enabled = false;
	}

	
	/** 
	 * @return int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	
	/** 
	 * @param obj
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
