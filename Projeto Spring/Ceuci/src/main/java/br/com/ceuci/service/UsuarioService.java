package br.com.ceuci.service;

import java.nio.charset.Charset;
import java.util.Optional;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.ceuci.model.UserLogin;
import br.com.ceuci.model.Usuario;
import br.com.ceuci.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Optional<Usuario> cadastrarUsuari(Usuario usuario) {
		if (usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			Optional.empty();
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		return Optional.of(usuarioRepository.save(usuario));

	}

	@SuppressWarnings("unused")
	private String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}

	private boolean compararSenhas(String senhaDigitada, String senhaBanco) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		return encoder.matches(senhaDigitada, senhaBanco);

	}
	
	private String gerarBasicToken(String usuario, String senha) {

		String token = usuario + ":" + senha;
		byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(tokenBase64);

	}

	public Optional<UserLogin> LogarUsuario(Optional<UserLogin> userLogin) {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario(userLogin.get().getUsuario());

		if (usuario.isPresent()) {
               if(compararSenhas(userLogin.get().getSenha(),usuario.get().getSenha())){            	   
            	userLogin.get().setId(usuario.get().getId());
            	userLogin.get().setNome(usuario.get().getNome());
            	userLogin.get().setUsuario(usuario.get().getUsuario());
            	userLogin.get().setToken(gerarBasicToken(userLogin.get().getUsuario(), userLogin.get().getSenha()));
            	userLogin.get().setSenha(usuario.get().getSenha());

            	return userLogin;   
               }
                         
		}
            return Optional.empty();
	}

}