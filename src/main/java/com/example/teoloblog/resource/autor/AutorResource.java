package com.example.teoloblog.resource.autor;

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

import com.example.teoloblog.dto.autor.AutorDTO;
import com.example.teoloblog.dto.autor.AutorFormDTO;
import com.example.teoloblog.service.autor.AutorService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("api/teoloblog/autor")
@RequiredArgsConstructor
public class AutorResource {

	private final AutorService autorService;

	@GetMapping
	public ResponseEntity<List<AutorDTO>> listarAutors() {
		return ResponseEntity.ok(autorService.listarAutors());
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<AutorDTO> buscarAutor(@PathVariable("codigo") Integer codigoAutor)
			throws Exception {
		return ResponseEntity.ok(autorService.buscarAutorPorId(codigoAutor));
	}

	@PostMapping
	public ResponseEntity<AutorDTO> salvarAutor(@RequestBody AutorFormDTO autorFormDTO)
			throws Exception {

		AutorDTO autor = autorService.adicionarAutor(autorFormDTO);

		return ResponseEntity.ok(autor);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<AutorDTO> editarAutor(@PathVariable("codigo") Integer codigoAutor,
			@RequestBody AutorFormDTO autorFormDTO) throws Exception {

		AutorDTO autor = autorService.editarAutor(codigoAutor, autorFormDTO);

		return ResponseEntity.status(HttpStatus.OK).body(autor);
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<AutorDTO> excluirAutor(@PathVariable("codigo") Integer codigoAutor)
			throws Exception {

		autorService.excluirAutor(codigoAutor);

		return ResponseEntity.ok().build();
	}

}