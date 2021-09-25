package com.example.teoloblog.service.usuario;

import com.example.teoloblog.dto.usuario.UsuarioDTO;
import com.example.teoloblog.dto.usuario.UsuarioFormDTO;

import java.util.List;

public interface UsuarioService {
    public List<UsuarioDTO> listaUsuarios();
    public UsuarioDTO buscaUsuario(Integer codigo) throws Exception;
    public UsuarioDTO adicionaUsuario(UsuarioFormDTO usuarioFormDTO) throws Exception;
    public UsuarioDTO editaUsuario(Integer codigo,UsuarioFormDTO usuarioFormDTO) throws Exception;
    public void deletaUsuario(Integer codigo) throws Exception;
}
