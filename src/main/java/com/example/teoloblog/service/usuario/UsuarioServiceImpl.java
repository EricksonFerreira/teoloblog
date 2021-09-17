package com.example.teoloblog.service.usuario;

// import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.teoloblog.convert.usuario.UsuarioConvert;
import com.example.teoloblog.domain.usuario.Usuario;
import com.example.teoloblog.dto.usuario.UsuarioDTO;
import com.example.teoloblog.dto.usuario.UsuarioFormDTO;
import com.example.teoloblog.repository.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository usuarioRepository;

	// @Override
	// public List<UsuarioDTO> listarUsuarios() {

	// 	List<Usuario> usuarioList = usuarioRepository.findAll();
	// 	return UsuarioConvert.usuarioDomainListToDTOlist(usuarioList);
	// }

	// @Override
	// public UsuarioDTO buscarUsuarioPorId(Integer codigoUsuario) throws Exception {
	// 	Optional<Usuario> usuarioOpt = usuarioRepository.findById(codigoUsuario);
		
	// 	if (!usuarioOpt.isPresent()) {
	// 		throw new Exception("Usuario não encontrada");
	// 	}
		
	// 	return UsuarioConvert.usuarioDomainToDTO(usuarioOpt.get());
	// }

	@Override
	public UsuarioDTO adicionarUsuario(UsuarioFormDTO usuarioForm) {
		
		Usuario entity = UsuarioConvert.usuarioFormToUsuarioEntity(usuarioForm);
		usuarioRepository.save(entity);
		
		return UsuarioConvert.usuarioDomainToDTO(entity);
	}

	@Override
	public UsuarioDTO editarUsuario(Integer codigoUsuario, UsuarioFormDTO usuarioForm) throws Exception {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(codigoUsuario);
		
		if (!usuarioOpt.isPresent()) {
			throw new Exception("Usuario não encontrada");
		}
		
		Usuario entity = usuarioOpt.get();
		
		entity.setNome(usuarioForm.getNome());
		usuarioRepository.save(entity);
		
		return UsuarioConvert.usuarioDomainToDTO(entity);
	}

	@Override
	public void excluirUsuario(Integer codigoUsuario) throws Exception {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(codigoUsuario);
		
		if (!usuarioOpt.isPresent()) {
			throw new Exception("Usuario não encontrada");
		}
		
		usuarioRepository.delete(usuarioOpt.get());
	}

}