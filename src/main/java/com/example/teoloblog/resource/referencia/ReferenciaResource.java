package com.example.teoloblog.resource.referencia;

import java.util.List;

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

import com.example.teoloblog.dto.referencia.ReferenciaDTO;
import com.example.teoloblog.dto.referencia.ReferenciaFormDTO;
import com.example.teoloblog.service.referencia.ReferenciaService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("api/teoloblog/referencia")
@RequiredArgsConstructor
public class ReferenciaResource {
    private final ReferenciaService referenciaService;

    @GetMapping
    public ResponseEntity<List<ReferenciaDTO>> listarReferencias(){
        return ResponseEntity.ok(referenciaService.listarReferencias());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ReferenciaDTO> buscarReferencia(@PathVariable("codigo") Integer codigoReferencia)
            throws Exception{
        return ResponseEntity.ok(referenciaService.buscarReferenciaPorId(codigoReferencia));
    }

    @PostMapping
    public ResponseEntity<ReferenciaDTO> salvarReferencia(@RequestBody ReferenciaFormDTO referenciaFormDTO) throws Exception{
        ReferenciaDTO referencia = referenciaService.adicionaReferencia(referenciaFormDTO);

        return ResponseEntity.ok(referencia);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<ReferenciaDTO> editarReferencia(@PathVariable("codigo") Integer codigoFormDTO,
        @RequestBody ReferenciaFormDTO referenciaFormDTO) throws Exception{
        
        ReferenciaDTO referencia = referenciaService.editarReferencia(codigoFormDTO, referenciaFormDTO);

        return ResponseEntity.ok(referencia);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<ReferenciaDTO> excluirReferencia(@PathVariable("codigo") Integer codigoReferencia) throws Exception{
        referenciaService.excluirReferencia(codigoReferencia);
        return ResponseEntity.ok().build();
    }
}
