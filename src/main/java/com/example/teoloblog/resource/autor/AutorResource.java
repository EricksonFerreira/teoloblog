package com.example.teoloblog.resource.autor;

import com.example.teoloblog.dto.autor.AutorDTO;
import com.example.teoloblog.service.autor.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/autor")
@RequiredArgsConstructor
public class AutorResource {

	private final AutorService autorService;

	@GetMapping
	public ResponseEntity<List<AutorDTO>> listarAutores() {
		return ResponseEntity.ok(autorService.listaAutores());
	}

}
