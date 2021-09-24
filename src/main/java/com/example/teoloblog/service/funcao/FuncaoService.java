package com.example.teoloblog.service.funcao;

import com.example.teoloblog.dto.funcao.FuncaoDTO;
import com.example.teoloblog.dto.funcao.FuncaoFormDTO;

import java.util.List;

public interface FuncaoService {
    public List<FuncaoDTO> listarFuncoes();
    public FuncaoDTO buscarFuncaoPorCodigo(Integer codigo) throws Exception;

    public FuncaoDTO adicionaFuncao(FuncaoFormDTO funcaoFormDTO);
    public FuncaoDTO editaFuncao(Integer codigo,FuncaoFormDTO funcaoFormDTO) throws Exception;

    public void deletaFuncao(Integer codigo) throws Exception;
}
