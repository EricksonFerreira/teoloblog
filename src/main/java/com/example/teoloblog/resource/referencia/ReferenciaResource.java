package com.example.teoloblog.resource.referencia;

import com.example.teoloblog.dto.referencia.ReferenciaDTO;
import com.example.teoloblog.dto.referencia.ReferenciaFormDTO;
import com.example.teoloblog.service.referencia.ReferenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/referencia")
@RequiredArgsConstructor
public class ReferenciaResource {

    private final ReferenciaService referenciaService;

    @GetMapping
    public ResponseEntity<List<ReferenciaDTO>> listaReferencias() {
        return ResponseEntity.ok(referenciaService.listaReferencias());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ReferenciaDTO> buscaReferencia(@PathVariable("codigo") Integer codigo) throws Exception {
        return ResponseEntity.ok(referenciaService.buscaReferencia(codigo));
    }

    @PostMapping
    public ResponseEntity<ReferenciaDTO> adicionaReferencia(@RequestBody ReferenciaFormDTO referenciaFormDTO) throws Exception {
        ReferenciaDTO referencia = referenciaService.adicionaReferencia(referenciaFormDTO);
        return ResponseEntity.ok(referencia);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<ReferenciaDTO> editaReferencia(@PathVariable("codigo")Integer codigo,@RequestBody ReferenciaFormDTO referenciaFormDTO) throws Exception {
        ReferenciaDTO referencia = referenciaService.editaReferencia(codigo,referenciaFormDTO);
        return ResponseEntity.status(HttpStatus.OK).body(referencia);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<ReferenciaDTO> deletaReferencia(@PathVariable("codigo") Integer codigo) throws Exception {
        referenciaService.deletaReferencia(codigo);
        return ResponseEntity.ok().build();
    }
}
