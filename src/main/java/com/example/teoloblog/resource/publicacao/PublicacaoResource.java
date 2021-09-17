package com.example.teoloblog.resource.publicacao;

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

import com.example.teoloblog.dto.publicacao.PublicacaoDTO;
import com.example.teoloblog.dto.publicacao.PublicacaoFormDTO;
import com.example.teoloblog.service.publicacao.PublicacaoService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("api/teoloblog/publicacao")
@RequiredArgsConstructor
public class PublicacaoResource {
    private final PublicacaoService publicacaoService;

    @GetMapping
    public ResponseEntity<List<PublicacaoDTO>> listarPublicacaos(){
        return ResponseEntity.ok(publicacaoService.listarPublicacaos());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<PublicacaoDTO> buscarPublicacao(@PathVariable("codigo") Integer codigoPublicacao)
            throws Exception{
        return ResponseEntity.ok(publicacaoService.buscarPublicacaoPorId(codigoPublicacao));
    }

    @PostMapping
    public ResponseEntity<PublicacaoDTO> salvarPublicacao(@RequestBody PublicacaoFormDTO publicacaoFormDTO) throws Exception{
        PublicacaoDTO publicacao = publicacaoService.adicionaPublicacao(publicacaoFormDTO);

        return ResponseEntity.ok(publicacao);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<PublicacaoDTO> editarPublicacao(@PathVariable("codigo") Integer codigoFormDTO,
        @RequestBody PublicacaoFormDTO publicacaoFormDTO) throws Exception{
        
        PublicacaoDTO publicacao = publicacaoService.editarPublicacao(codigoFormDTO, publicacaoFormDTO);

        return ResponseEntity.ok(publicacao);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<PublicacaoDTO> excluirPublicacao(@PathVariable("codigo") Integer codigoPublicacao) throws Exception{
        publicacaoService.excluirPublicacao(codigoPublicacao);
        return ResponseEntity.ok().build();
    }
}
