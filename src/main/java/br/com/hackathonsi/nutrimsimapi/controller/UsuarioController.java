package br.com.hackathonsi.nutrimsimapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hackathonsi.nutrimsimapi.model.Usuario;
import br.com.hackathonsi.nutrimsimapi.service.UsuarioService;

@RestController
public class UsuarioController {
	@Autowired
	private UsuarioService service;

	@RequestMapping(value = "/usuário", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		List<Usuario> listarUsuarios = service.listarTodos();
		return new ResponseEntity<List<Usuario>>(listarUsuarios, HttpStatus.OK);
	}

	@RequestMapping(value = "/usuario/{email}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> listarUsuarioById(@PathVariable String email) {
		Optional<Usuario> usuario = service.buscarUsuarioById(email);
		if (usuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Usuario>(HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public ResponseEntity<String> criarUsuario(@RequestBody Usuario usuario) {
		try {
			service.criarUsuario(usuario.getEmail(), usuario);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public UsuarioService getService() {
		return service;
	}

	public void setService(UsuarioService service) {
		this.service = service;
	}

}
