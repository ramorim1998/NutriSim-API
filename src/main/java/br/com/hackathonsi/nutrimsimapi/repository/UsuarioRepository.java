package br.com.hackathonsi.nutrimsimapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.hackathonsi.nutrimsimapi.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository <Usuario,String> {
	

}
