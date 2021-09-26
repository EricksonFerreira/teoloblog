package com.example.teoloblog.service.comentario;

import com.example.teoloblog.dto.comentario.ComentarioDTO;
import com.example.teoloblog.dto.comentario.ComentarioFormDTO;

import java.util.List;

public interface ComentarioService {
    public List<ComentarioDTO> listarComentarios();
    public ComentarioDTO buscarComentarioPorCodigo(Integer codigo) throws Exception;

    public ComentarioDTO adicionaComentario(ComentarioFormDTO comentarioFormDTO) throws Exception;
    public ComentarioDTO editaComentario(Integer codigo,ComentarioFormDTO comentarioFormDTO) throws Exception;

    public void deletaComentario(Integer codigo) throws Exception;
}
