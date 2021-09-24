package com.example.teoloblog.resource.funcao;

import com.example.teoloblog.domain.autor.Autor;
import com.example.teoloblog.domain.funcao.Funcao;
import com.example.teoloblog.dto.autor.AutorDTO;
import com.example.teoloblog.dto.funcao.FuncaoDTO;
import com.example.teoloblog.dto.funcao.FuncaoFormDTO;
import com.example.teoloblog.service.funcao.FuncaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/funcao")
@RequiredArgsConstructor
public class FuncaoResource {

    private final FuncaoService funcaoService;

    @GetMapping
    public ResponseEntity<List<FuncaoDTO>> listarFuncoes() {
        return ResponseEntity.ok(funcaoService.listarFuncoes());
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<FuncaoDTO> buscarFuncao(@PathVariable("codigo") Integer codigo) throws Exception {
        return ResponseEntity.ok(funcaoService.buscarFuncaoPorCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<FuncaoDTO> adicionaFuncao(@RequestBody FuncaoFormDTO funcaoFormDTO){
        FuncaoDTO funcao = funcaoService.adicionaFuncao(funcaoFormDTO);
        return ResponseEntity.ok(funcao);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<FuncaoDTO> editarFuncao(@PathVariable("codigo") Integer codigo,@RequestBody FuncaoFormDTO funcaoFormDTO) throws Exception{
        FuncaoDTO funcao = funcaoService.editaFuncao(codigo,funcaoFormDTO);
        return ResponseEntity.status(HttpStatus.OK).body(funcao);
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<FuncaoDTO> deletaFuncao(@PathVariable("codigo") Integer codigo) throws Exception{
        funcaoService.deletaFuncao(codigo);
       return ResponseEntity.ok().build();
    }
}
