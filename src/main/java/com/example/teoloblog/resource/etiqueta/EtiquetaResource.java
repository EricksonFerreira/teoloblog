package com.example.teoloblog.resource.etiqueta;

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

import com.example.teoloblog.dto.etiqueta.EtiquetaDTO;
import com.example.teoloblog.dto.etiqueta.EtiquetaFormDTO;
import com.example.teoloblog.service.etiqueta.EtiquetaService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("api/teoloblog/etiqueta")
@RequiredArgsConstructor
public class EtiquetaResource {

	private final EtiquetaService etiquetaService;

	@GetMapping
	public ResponseEntity<List<EtiquetaDTO>> listarEtiquetas() {
		return ResponseEntity.ok(etiquetaService.listarEtiquetas());
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<EtiquetaDTO> buscarEtiqueta(@PathVariable("codigo") Integer codigoEtiqueta)
			throws Exception {
		return ResponseEntity.ok(etiquetaService.buscarEtiquetaPorId(codigoEtiqueta));
	}

	@PostMapping
	public ResponseEntity<EtiquetaDTO> salvarEtiqueta(@RequestBody EtiquetaFormDTO etiquetaFormDTO)
			throws Exception {

		EtiquetaDTO etiqueta = etiquetaService.adicionarEtiqueta(etiquetaFormDTO);

		return ResponseEntity.ok(etiqueta);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<EtiquetaDTO> editarEtiqueta(@PathVariable("codigo") Integer codigoEtiqueta,
			@RequestBody EtiquetaFormDTO etiquetaFormDTO) throws Exception {

		EtiquetaDTO etiqueta = etiquetaService.editarEtiqueta(codigoEtiqueta, etiquetaFormDTO);

		return ResponseEntity.status(HttpStatus.OK).body(etiqueta);
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<EtiquetaDTO> excluirEtiqueta(@PathVariable("codigo") Integer codigoEtiqueta)
			throws Exception {

		etiquetaService.excluirEtiqueta(codigoEtiqueta);

		return ResponseEntity.ok().build();
	}

}