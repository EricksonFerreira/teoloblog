package com.example.teoloblog.service.autor;

import com.example.teoloblog.domain.autor.Autor;
import com.example.teoloblog.dto.autor.AutorDTO;
import com.example.teoloblog.dto.autor.AutorFormDTO;

import java.util.List;

public interface AutorService {
    List<AutorDTO> listaAutores();
    AutorDTO buscarAutorPorId(Integer codigoAutor) throws Exception;
    AutorDTO adicionaAutor(AutorFormDTO autorForm);
    AutorDTO editarAutor(Integer codigoAutor,AutorFormDTO autorForm) throws Exception;
    void excluirAutor(Integer codigoAutor) throws Exception;

}
