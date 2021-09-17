package com.example.teoloblog.resource.usuario;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teoloblog.dto.usuario.UsuarioDTO;
import com.example.teoloblog.dto.usuario.UsuarioFormDTO;
import com.example.teoloblog.service.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("api/teoloblog/user")
@RequiredArgsConstructor
public class UsuarioResource {

	private final UsuarioService usuarioService;

	// @GetMapping
	// public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
	// 	return ResponseEntity.ok(usuarioService.listarUsuarios());
	// }

	// @GetMapping("/{codigo}")
	// public ResponseEntity<UsuarioDTO> buscarUsuario(@PathVariable("codigo") Integer codigoUsuario)
	// 		throws Exception {
	// 	return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(codigoUsuario));
	// }

	@PostMapping
	public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioFormDTO usuarioFormDTO)
			throws Exception {

		UsuarioDTO usuario = usuarioService.adicionarUsuario(usuarioFormDTO);

		return ResponseEntity.ok(usuario);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<UsuarioDTO> editarUsuario(@PathVariable("codigo") Integer codigoUsuario,
			@RequestBody UsuarioFormDTO usuarioFormDTO) throws Exception {

		UsuarioDTO usuario = usuarioService.editarUsuario(codigoUsuario, usuarioFormDTO);

		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<UsuarioDTO> excluirUsuario(@PathVariable("codigo") Integer codigoUsuario)
			throws Exception {

		usuarioService.excluirUsuario(codigoUsuario);

		return ResponseEntity.ok().build();
	}

}