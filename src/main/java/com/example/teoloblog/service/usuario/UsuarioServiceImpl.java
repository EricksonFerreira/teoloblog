package com.example.teoloblog.service.usuario;

import com.example.teoloblog.convert.funcao.FuncaoConvert;
import com.example.teoloblog.convert.usuario.UsuarioConvert;
import com.example.teoloblog.domain.funcao.Funcao;
import com.example.teoloblog.domain.usuario.Usuario;
import com.example.teoloblog.dto.usuario.UsuarioDTO;
import com.example.teoloblog.dto.usuario.UsuarioFormDTO;
import com.example.teoloblog.repository.funcao.FuncaoRepository;
import com.example.teoloblog.repository.usuario.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    public final UsuarioRepository usuarioRepository;
    public final FuncaoRepository funcaoRepository;

    @Override
    public List<UsuarioDTO> listaUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioConvert.usuarioDomainListToDTOlist(usuarios);
    }

    @Override
    public UsuarioDTO buscaUsuario(Integer codigo) throws Exception {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(codigo);
        if(!usuarioOpt.isPresent()){
            throw new Exception("Não existe esse usuario no sistema!");
        }

        return UsuarioConvert.usuarioDomainToDTO(usuarioOpt.get());
    }

    @Override
    public UsuarioDTO adicionaUsuario(UsuarioFormDTO usuarioFormDTO) throws Exception {
        Optional<Funcao> funcaoOpt = funcaoRepository.findById(usuarioFormDTO.getFuncaoId());
        if(!funcaoOpt.isPresent()){
            throw new Exception("Não existe esse função no sistema!");
        }

        Usuario entity = Usuario.builder()
                                .nome(usuarioFormDTO.getNome())
                                .password(usuarioFormDTO.getPassword())
                                .username(usuarioFormDTO.getUsername())
                                .funcao(funcaoOpt.get())
                                .build();

        usuarioRepository.save(entity);

        return UsuarioConvert.usuarioDomainToDTO(entity);
    }

    @Override
    public UsuarioDTO editaUsuario(Integer codigo, UsuarioFormDTO usuarioFormDTO) throws Exception {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(codigo);
        if(!usuarioOpt.isPresent()){
            throw new Exception("Não existe esse usuario no sistema!");
        }

       Optional<Funcao> funcaoOpt = funcaoRepository.findById(usuarioFormDTO.getFuncaoId());
        if(!funcaoOpt.isPresent()){
            throw new Exception("Não existe esse função no sistema!");
        }

        Usuario entity = usuarioOpt.get();
        entity.setNome(usuarioFormDTO.getNome());
        entity.setUsername(usuarioFormDTO.getUsername());
        entity.setPassword(usuarioFormDTO.getPassword());
        entity.setFuncao(funcaoOpt.get());
        usuarioRepository.save(entity);

        return UsuarioConvert.usuarioDomainToDTO(entity);
    }

    @Override
    public void deletaUsuario(Integer codigo) throws Exception {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(codigo);
        if(!usuarioOpt.isPresent()){
            throw new Exception("Não existe esse usuario no sistema!");
        }
        usuarioRepository.delete(usuarioOpt.get());
    }
}
