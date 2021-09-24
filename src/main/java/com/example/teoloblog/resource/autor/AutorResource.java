package com.example.teoloblog.resource.autor;

import com.example.teoloblog.domain.autor.Autor;
import com.example.teoloblog.dto.autor.AutorDTO;
import com.example.teoloblog.dto.autor.AutorFormDTO;
import com.example.teoloblog.service.autor.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
	@GetMapping("/{id}")
	public ResponseEntity<AutorDTO> buscarAutor(@PathVariable("id") Integer id) throws Exception{
		return ResponseEntity.ok(autorService.buscarAutorPorId(id));
	}

	@PostMapping
	public ResponseEntity<AutorDTO> adicionaAutor(@RequestBody AutorFormDTO autorFormDTO){
		AutorDTO autor = autorService.adicionaAutor(autorFormDTO);
		return ResponseEntity.ok(autor);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<AutorDTO> editarAutor(@PathVariable("codigo") Integer codigo,@RequestBody AutorFormDTO autorFormDTO) throws Exception{
		AutorDTO autor = autorService.editarAutor(codigo,autorFormDTO);
		return ResponseEntity.status(HttpStatus.OK).body(autor);
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<AutorDTO> deletarAutor(@PathVariable("codigo") Integer codigo) throws Exception{
		autorService.excluirAutor(codigo);

		return ResponseEntity.ok().build();
	}
}
