package es.indra.academiamvc.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.indra.academiamvc.model.entities.Usuario;
import es.indra.academiamvc.model.service.UsuarioService;

@Service("autenticacionService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usu = this.usuarioService.buscarUsuario(username);
		if (usu == null) {
			return null;
		}
		MyUserDetails user = new MyUserDetails(usu);
		return user;

	}

}