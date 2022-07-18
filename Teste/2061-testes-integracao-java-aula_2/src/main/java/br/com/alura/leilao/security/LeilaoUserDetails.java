package br.com.alura.leilao.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.alura.leilao.model.Usuario;

public class LeilaoUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Usuario user;

	public LeilaoUserDetails(Usuario user) {
		this.user = user;
	}

	
	/** 
	 * @return Collection<? extends GrantedAuthority>
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
		return Arrays.asList(authority);
	}

	
	/** 
	 * @return Usuario
	 */
	public Usuario getUsuario() {
		return this.user;
	}

	
	/** 
	 * @return String
	 */
	@Override
	public String getPassword() {
		return user.getSenha();
	}

	
	/** 
	 * @return String
	 */
	@Override
	public String getUsername() {
		return user.getNome();
	}

	
	/** 
	 * @return boolean
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	
	/** 
	 * @return boolean
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	
	/** 
	 * @return boolean
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	
	/** 
	 * @return boolean
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

}
