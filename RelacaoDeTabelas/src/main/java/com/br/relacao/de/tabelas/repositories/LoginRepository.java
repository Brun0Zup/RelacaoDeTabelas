package com.br.relacao.de.tabelas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.relacao.de.tabelas.models.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Integer>{

}
