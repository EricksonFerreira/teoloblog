package com.example.teoloblog.resource.etiqueta;

import com.example.teoloblog.dto.etiqueta.EtiquetaDTO;
import com.example.teoloblog.dto.etiqueta.EtiquetaFormDTO;
import com.example.teoloblog.repository.etiqueta.EtiquetaRepository;
import com.example.teoloblog.service.etiqueta.EtiquetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/etiqueta")
@RequiredArgsConstructor
public class EtiquetaResource {
    private final EtiquetaService etiquetaService;

    @GetMapping
    public ResponseEntity<List<EtiquetaDTO>> listaEtiquetas(){
        List<EtiquetaDTO> listaEtiquetas = etiquetaService.listaEtiqueta();
        return ResponseEntity.ok(listaEtiquetas);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<EtiquetaDTO> buscaEtiqueta(@PathVariable("codigo") Integer codigo) throws Exception {
        EtiquetaDTO etiqueta = etiquetaService.buscaEtiquetaPorCodigo(codigo);
        return ResponseEntity.ok(etiqueta);
    }

    @PostMapping
    public ResponseEntity<EtiquetaDTO> adicionaEtiqueta(@RequestBody EtiquetaFormDTO etiquetaFormDTO){
        EtiquetaDTO etiqueta = etiquetaService.adicionaEtiqueta(etiquetaFormDTO);
        return ResponseEntity.ok(etiqueta);
    }
    @PutMapping("/{codigo}")
    public ResponseEntity<EtiquetaDTO> editaEtiqueta(@PathVariable("codigo")Integer codigo,@RequestBody EtiquetaFormDTO etiquetaFormDTO) throws Exception {
        EtiquetaDTO etiqueta = etiquetaService.editaEtiqueta(codigo,etiquetaFormDTO);
        return ResponseEntity.status(HttpStatus.OK).body(etiqueta);
    }
    @DeleteMapping("{codigo}")
    public ResponseEntity<EtiquetaDTO> deletaEtiqueta(@PathVariable("codigo") Integer codigo) throws Exception {
        etiquetaService.deletaEtiqueta(codigo);
        return ResponseEntity.ok().build();
    }
}
