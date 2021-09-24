package com.example.teoloblog.service.etiqueta;

import com.example.teoloblog.convert.etiqueta.EtiquetaConvert;
import com.example.teoloblog.domain.etiqueta.Etiqueta;
import com.example.teoloblog.dto.etiqueta.EtiquetaDTO;
import com.example.teoloblog.dto.etiqueta.EtiquetaFormDTO;
import com.example.teoloblog.repository.etiqueta.EtiquetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Convert;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EtiquetaServiceImpl implements EtiquetaService{
    private final EtiquetaRepository etiquetaRepository;

    @Override
    public List<EtiquetaDTO> listaEtiqueta() {
        List<Etiqueta> etiquetas =  etiquetaRepository.findAll();
        return EtiquetaConvert.etiquetaDomainListToDTOlist(etiquetas);
    }

    @Override
    public EtiquetaDTO buscaEtiquetaPorCodigo(Integer codigo) throws Exception {
        Optional<Etiqueta> etiquetaOpt = etiquetaRepository.findById(codigo);
        if(!etiquetaOpt.isPresent()){
            throw new Exception("Não existe essa etiqueta");
        }

        return EtiquetaConvert.etiquetaDomainToDTO(etiquetaOpt.get());
    }

    @Override
    public EtiquetaDTO adicionaEtiqueta(EtiquetaFormDTO etiquetaFormDTO) {
        Etiqueta etiqueta = EtiquetaConvert.etiquetaFormToEtiquetaEntity(etiquetaFormDTO);
        etiquetaRepository.save(etiqueta);

        return EtiquetaConvert.etiquetaDomainToDTO(etiqueta);
    }

    @Override
    public EtiquetaDTO editaEtiqueta(Integer id, EtiquetaFormDTO etiquetaFormDTO) throws Exception {
        Optional<Etiqueta> etiquetaOpt = etiquetaRepository.findById(id);
        if(!etiquetaOpt.isPresent()){
            throw new Exception("Não existe essa etiqueta!");
        }

        Etiqueta etiqueta = etiquetaOpt.get();
        etiqueta.setNome(etiquetaFormDTO.getNome());
        etiquetaRepository.save(etiqueta);

        return EtiquetaConvert.etiquetaDomainToDTO(etiqueta);
    }

    @Override
    public void deletaEtiqueta(Integer id) throws Exception {
        Optional<Etiqueta> etiquetaOpt = etiquetaRepository.findById(id);
        if(!etiquetaOpt.isPresent()){
            throw new Exception("Não existe essa etiqueta!");
        }

        etiquetaRepository.delete(etiquetaOpt.get());
    }
}
