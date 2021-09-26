package com.example.teoloblog.resource.comentario;

import com.example.teoloblog.dto.comentario.ComentarioDTO;
import com.example.teoloblog.dto.comentario.ComentarioFormDTO;
import com.example.teoloblog.service.comentario.ComentarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/comentario")
@RequiredArgsConstructor
public class ComentarioResource {
     private final ComentarioService comentarioService;

    @GetMapping
    public ResponseEntity<List<ComentarioDTO>> listaPublicacoes() {
        return ResponseEntity.ok(comentarioService.listarComentarios());
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<ComentarioDTO> busccaComentario(@PathVariable("codigo") Integer codigo) throws Exception {
        return ResponseEntity.ok(comentarioService.buscarComentarioPorCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<ComentarioDTO> adicionaUsuario(@RequestBody ComentarioFormDTO comentarioFormDTO) throws Exception {
        ComentarioDTO comentario = comentarioService.adicionaComentario(comentarioFormDTO);
        return ResponseEntity.ok(comentario);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<ComentarioDTO> editaComentario(@PathVariable("codigo")Integer codigo,@RequestBody ComentarioFormDTO comentarioFormDTO) throws Exception {
        ComentarioDTO comentario = comentarioService.editaComentario(codigo,comentarioFormDTO);
        return ResponseEntity.status(HttpStatus.OK).body(comentario);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<ComentarioDTO> deletaComentario(@PathVariable("codigo") Integer codigo) throws Exception {
        comentarioService.deletaComentario(codigo);
        return ResponseEntity.ok().build();
    }
}
