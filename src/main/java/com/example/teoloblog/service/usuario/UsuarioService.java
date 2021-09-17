package com.example.teoloblog.service.usuario;

import com.example.teoloblog.dto.usuario.UsuarioDTO;
import com.example.teoloblog.dto.usuario.UsuarioFormDTO;



public interface UsuarioService {

    // List<UsuarioDTO> listarUsuarios();
    // UsuarioDTO buscarUsuarioPorId(Integer codigoUsuario) throws Exception;

    UsuarioDTO adicionarUsuario(UsuarioFormDTO usuarioForm);
    UsuarioDTO editarUsuario(Integer codigoUsuario, UsuarioFormDTO usuarioForm) throws Exception;

    void excluirUsuario(Integer codigoUsuario) throws Exception;

    
}