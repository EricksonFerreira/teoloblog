package com.example.teoloblog.service.autor;

import java.util.List;

import com.example.teoloblog.dto.autor.AutorDTO;
import com.example.teoloblog.dto.autor.AutorFormDTO;



public interface AutorService {

    List<AutorDTO> listarAutors();
    AutorDTO buscarAutorPorId(Integer codigoAutor) throws Exception;

    AutorDTO adicionarAutor(AutorFormDTO autorForm);
    AutorDTO editarAutor(Integer codigoAutor, AutorFormDTO autorForm) throws Exception;

    void excluirAutor(Integer codigoAutor) throws Exception;

    
}