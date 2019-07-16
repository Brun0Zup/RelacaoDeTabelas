package com.br.relacao.de.tabelas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.relacao.de.tabelas.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	

}
