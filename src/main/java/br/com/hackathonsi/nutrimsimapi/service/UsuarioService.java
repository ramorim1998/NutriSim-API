package br.com.hackathonsi.nutrimsimapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.hackathonsi.nutrimsimapi.model.Usuario;
import br.com.hackathonsi.nutrimsimapi.repository.UsuarioRepository;

@Service
@Validated
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Optional<Usuario> buscarUsuarioById(String email) {
		return repository.findById(email);
	}
	public List<Usuario> listarTodos() {
		return repository.findAll();
	}
	public Usuario criarUsuario(String email, Usuario usuario) {
		return repository.save(usuario);
	}
	public void deletarUsuario(String email, Usuario usuario) {
		repository.delete(usuario);
	}
	

}
