package com.example.teoloblog.resource.publicacao;

import com.example.teoloblog.domain.publicacao.Publicacao;
import com.example.teoloblog.dto.publicacao.PublicacaoDTO;
import com.example.teoloblog.dto.publicacao.PublicacaoFormDTO;
import com.example.teoloblog.service.publicacao.PublicacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/publicacao")
@RequiredArgsConstructor
public class PublicacaoResource {

       private final PublicacaoService publicacaoService;

    @GetMapping
    public ResponseEntity<List<PublicacaoDTO>> listaPublicacoes() {
        return ResponseEntity.ok(publicacaoService.listaPublicacoes());
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<PublicacaoDTO> busccaPublicacao(@PathVariable("codigo") Integer codigo) throws Exception {
        return ResponseEntity.ok(publicacaoService.buscaPublicacao(codigo));
    }

    @PostMapping
    public ResponseEntity<PublicacaoDTO> adicionPublicacao(@RequestBody PublicacaoFormDTO publicacaoFormDTO) throws Exception {
        PublicacaoDTO publicacao = publicacaoService.adicionaPublicacao(publicacaoFormDTO);
        return ResponseEntity.ok(publicacao);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<PublicacaoDTO> editaPublicacao(@PathVariable("codigo") Integer codigo,@RequestBody PublicacaoFormDTO publicacaoFormDTO) throws Exception {
        PublicacaoDTO publicacao = publicacaoService.editaPublicacao(codigo,publicacaoFormDTO);
        return ResponseEntity.status(HttpStatus.OK).body(publicacao);
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<PublicacaoDTO> deletePublicacao(@PathVariable("codigo") Integer codigo) throws Exception {
        publicacaoService.deletaPublicacao(codigo);
        return ResponseEntity.ok().build();
    }
}
