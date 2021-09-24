package com.example.teoloblog.service.funcao;

import com.example.teoloblog.convert.funcao.FuncaoConvert;
import com.example.teoloblog.domain.funcao.Funcao;
import com.example.teoloblog.domain.usuario.Usuario;
import com.example.teoloblog.dto.funcao.FuncaoDTO;
import com.example.teoloblog.dto.funcao.FuncaoFormDTO;
import com.example.teoloblog.repository.funcao.FuncaoRepository;
import com.example.teoloblog.repository.usuario.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FuncaoServiceImpl implements FuncaoService {

    private final FuncaoRepository funcaoRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<FuncaoDTO> listarFuncoes() {
        List<Funcao> funcoes = funcaoRepository.findAll();
        return FuncaoConvert.funcaoDomainListToDTOlist(funcoes);
    }

    @Override
    public FuncaoDTO buscarFuncaoPorCodigo(Integer codigo) throws Exception{
        Optional<Funcao> funcaoOpt = funcaoRepository.findById(codigo);
        if(!funcaoOpt.isPresent()){
        }
        return FuncaoConvert.funcaoDomainToDTO(funcaoOpt.get());
    }

    @Override
    public FuncaoDTO adicionaFuncao(FuncaoFormDTO funcaoFormDTO){
        Funcao entity = FuncaoConvert.funcaoFormToFuncaoEntity(funcaoFormDTO);
        funcaoRepository.save(entity);
        return FuncaoConvert.funcaoDomainToDTO(entity);
    }

    @Override
    public FuncaoDTO editaFuncao(Integer codigo, FuncaoFormDTO funcaoForm) throws Exception {
        Optional<Funcao> funcaoOpt = funcaoRepository.findById(codigo);
        if(!funcaoOpt.isPresent()){
            throw new Exception("Função não encotrada");
        }

        Funcao entity = funcaoOpt.get();
        entity.setNome(funcaoForm.getNome());
		funcaoRepository.save(entity);
        return FuncaoConvert.funcaoDomainToDTO(entity);
    }

     @Override
    public void deletaFuncao(Integer codigo) throws Exception {

        Optional<Funcao> funcaoOpt = funcaoRepository.findById(codigo);
        if(!funcaoOpt.isPresent()){
            throw new Exception("Função não encontrada");
        }

        Optional<Usuario> usuarioOpt = usuarioRepository.findByFuncao(funcaoOpt.get());
        if(usuarioOpt.isPresent()){
            throw new Exception("Essa função está sendo utilizada em um usuário");
        }

        funcaoRepository.delete(funcaoOpt.get());
    }
}
