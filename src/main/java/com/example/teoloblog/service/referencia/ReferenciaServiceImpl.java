package com.example.teoloblog.service.referencia;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.teoloblog.convert.referencia.ReferenciaConvert;
import com.example.teoloblog.domain.referencia.Referencia;
import com.example.teoloblog.domain.publicacao.Publicacao;
import com.example.teoloblog.dto.referencia.ReferenciaDTO;
import com.example.teoloblog.dto.referencia.ReferenciaFormDTO;
import com.example.teoloblog.repository.referencia.ReferenciaRepository;
import com.example.teoloblog.repository.publicacao.PublicacaoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReferenciaServiceImpl implements ReferenciaService{

    private final ReferenciaRepository referenciaRepository;
    private final PublicacaoRepository publicacaoRepository;

    @Override
    public List<ReferenciaDTO> listarReferencias() {
        List<Referencia> referenciaList = referenciaRepository.findAll();
        return ReferenciaConvert.referenciaDomainListToDTOlist(referenciaList);
    }

    @Override
    public ReferenciaDTO buscarReferenciaPorId(Integer codigoReferencia) throws Exception {
        Optional<Referencia> referenciaOpt = referenciaRepository.findById(codigoReferencia);
    
        if (!referenciaOpt.isPresent()){
            throw new Exception("Referencia não encontrado");
        }

        return ReferenciaConvert.referenciaDomainToDTO(referenciaOpt.get());
    }

    @Override
    public ReferenciaDTO adicionaReferencia(ReferenciaFormDTO referenciaForm) throws Exception {
        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(referenciaForm.getPublicacaoId());
        
        if (!publicacaoOpt.isPresent()){
            throw new Exception("Publicacao não encontrada");
        }

        Referencia entity = ReferenciaConvert.referenciaFormToPublicacaoEntity(referenciaForm);
        entity.setPublicacao(publicacaoOpt.get());
        referenciaRepository.save(entity);

        return ReferenciaConvert.referenciaDomainToDTO(entity);
    }

    @Override
    public ReferenciaDTO editarReferencia(Integer codigoReferencia, ReferenciaFormDTO referenciaForm) throws Exception {
        Optional<Referencia> referenciaOpt = referenciaRepository.findById(codigoReferencia);

        if (!referenciaOpt.isPresent()){
            throw new Exception("Referencia não encontrado");
        }

        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(referenciaForm.getPublicacaoId());
        
        if (!publicacaoOpt.isPresent()){
            throw new Exception("Publicacao não encontrada");
        }

        Referencia entity = referenciaOpt.get();
        entity.setTexto(referenciaForm.getTexto());
        entity.setPublicacao(publicacaoOpt.get());
        referenciaRepository.save(entity);

        return ReferenciaConvert.referenciaDomainToDTO(referenciaOpt.get()); 
    }

    @Override
    public void excluirReferencia(Integer codigoReferencia) throws Exception {
        Optional<Referencia> referenciaOpt = referenciaRepository.findById(codigoReferencia);

        if(!referenciaOpt.isPresent()){
            throw new Exception("Referencia não encontrado");
        }

        referenciaRepository.delete(referenciaOpt.get());
    }
}
