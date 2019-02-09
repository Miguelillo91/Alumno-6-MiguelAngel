package es.indra.academiamvc.authentication;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import es.indra.academiamvc.model.entities.Usuario;

public class MyUserDetails implements UserDetails {

	private static final long serialVersionUID = -2101939031003054522L;
	private static final String ADMINISTRADOR = "Administrador";
	private Collection<GrantedAuthority> authorities = null;
	private String password = null;
	private String username = null;
	private long userid = 0;
	private String nick = null;
	private Boolean activo = true;

	public MyUserDetails(Collection<GrantedAuthority> authorities, String password, String username, long userid,
			String nick) {
		super();

		this.authorities = authorities;
		this.password = password;
		this.username = username;
		this.userid = userid;
		this.nick = nick;
	}

	public MyUserDetails(Usuario usuario) {
		super();
		ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		String[] permisos = usuario.getPermisos().split(";");
		for (String string : permisos) {
			roles.add(new MyGrantedAuthority(string));
		}

		this.authorities = roles;
		this.password = usuario.getClave();
		this.username = usuario.getUsuario();
		this.userid = usuario.getId();
		this.nick = usuario.getUsuario();
		this.activo = usuario.getHabilitado();
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.username;
	}

	public long getUserid() {
		return this.userid;
	}

	public String getNick() {
		return this.nick;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		return this.activo;
	}

}