package com.br.relacao.de.tabelas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.relacao.de.tabelas.models.Login;
import com.br.relacao.de.tabelas.models.Usuario;
import com.br.relacao.de.tabelas.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	
	public String salvarUsuario(Usuario usuario, Login login){
		login.setUsuario(usuario);
		 usuarioRepository.save(usuario);
		 return "Usuario cadastrado";
	}
	
	public Iterable<Usuario> pegarTodosUsuarios(){
		return usuarioRepository.findAll();
	}
}

