package com.example.teoloblog.service.etiqueta;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.teoloblog.convert.etiqueta.EtiquetaConvert;
import com.example.teoloblog.domain.etiqueta.Etiqueta;
import com.example.teoloblog.dto.etiqueta.EtiquetaDTO;
import com.example.teoloblog.dto.etiqueta.EtiquetaFormDTO;
import com.example.teoloblog.repository.etiqueta.EtiquetaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EtiquetaServiceImpl implements EtiquetaService {

	private final EtiquetaRepository etiquetaRepository;

	@Override
	public List<EtiquetaDTO> listarEtiquetas() {

		List<Etiqueta> etiquetaList = etiquetaRepository.findAll();
		return EtiquetaConvert.etiquetaDomainListToDTOlist(etiquetaList);
	}

	@Override
	public EtiquetaDTO buscarEtiquetaPorId(Integer codigoEtiqueta) throws Exception {
		Optional<Etiqueta> etiquetaOpt = etiquetaRepository.findById(codigoEtiqueta);
		
		if (!etiquetaOpt.isPresent()) {
			throw new Exception("Etiqueta não encontrada");
		}
		
		return EtiquetaConvert.etiquetaDomainToDTO(etiquetaOpt.get());
	}

	@Override
	public EtiquetaDTO adicionarEtiqueta(EtiquetaFormDTO etiquetaForm) {
		
		Etiqueta entity = EtiquetaConvert.etiquetaFormToEtiquetaEntity(etiquetaForm);
		etiquetaRepository.save(entity);
		
		return EtiquetaConvert.etiquetaDomainToDTO(entity);
	}

	@Override
	public EtiquetaDTO editarEtiqueta(Integer codigoEtiqueta, EtiquetaFormDTO etiquetaForm) throws Exception {
		Optional<Etiqueta> etiquetaOpt = etiquetaRepository.findById(codigoEtiqueta);
		
		if (!etiquetaOpt.isPresent()) {
			throw new Exception("Etiqueta não encontrada");
		}
		
		Etiqueta entity = etiquetaOpt.get();
		
		entity.setNome(etiquetaForm.getNome());
		etiquetaRepository.save(entity);
		
		return EtiquetaConvert.etiquetaDomainToDTO(entity);
	}

	@Override
	public void excluirEtiqueta(Integer codigoEtiqueta) throws Exception {
		Optional<Etiqueta> etiquetaOpt = etiquetaRepository.findById(codigoEtiqueta);
		
		if (!etiquetaOpt.isPresent()) {
			throw new Exception("Etiqueta não encontrada");
		}
		
		etiquetaRepository.delete(etiquetaOpt.get());
	}

}