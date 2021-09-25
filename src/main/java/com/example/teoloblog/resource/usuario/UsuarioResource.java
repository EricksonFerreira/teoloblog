package com.example.teoloblog.resource.usuario;

import com.example.teoloblog.domain.usuario.Usuario;
import com.example.teoloblog.dto.usuario.UsuarioDTO;
import com.example.teoloblog.dto.usuario.UsuarioFormDTO;
import com.example.teoloblog.repository.usuario.UsuarioRepository;
import com.example.teoloblog.service.usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/usuario")
@RequiredArgsConstructor
public class UsuarioResource {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listaUsuarios() {
        return ResponseEntity.ok(usuarioService.listaUsuarios());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<UsuarioDTO> buscaUsuario(@PathVariable("codigo") Integer codigo) throws Exception {
        return ResponseEntity.ok(usuarioService.buscaUsuario(codigo));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> adicionaUsuario(@RequestBody UsuarioFormDTO usuarioFormDTO) throws Exception {
        UsuarioDTO usuario = usuarioService.adicionaUsuario(usuarioFormDTO);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<UsuarioDTO> editaUsuario(@PathVariable("codigo")Integer codigo,@RequestBody UsuarioFormDTO usuarioFormDTO) throws Exception {
        UsuarioDTO usuario = usuarioService.editaUsuario(codigo,usuarioFormDTO);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<UsuarioDTO> deletaUsuario(@PathVariable("codigo") Integer codigo) throws Exception {
        usuarioService.deletaUsuario(codigo);
        return ResponseEntity.ok().build();
    }
}
