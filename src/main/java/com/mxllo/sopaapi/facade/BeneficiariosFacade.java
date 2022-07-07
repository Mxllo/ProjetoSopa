package com.mxllo.sopaapi.facade;

import com.mxllo.sopaapi.dto.BeneficiarioCadastro;
import com.mxllo.sopaapi.dto.BeneficiarioDTO;
import com.mxllo.sopaapi.dto.ContatoDTO;
import com.mxllo.sopaapi.dto.DoacaoDTO;
import com.mxllo.sopaapi.mapper.BeneficiarioMapper;
import com.mxllo.sopaapi.mapper.ContatoMapper;
import com.mxllo.sopaapi.models.Beneficiario;
import com.mxllo.sopaapi.models.Contato;
import com.mxllo.sopaapi.services.BeneficiarioService;
import com.mxllo.sopaapi.services.ContatoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;

@AllArgsConstructor
@Component
public class BeneficiariosFacade {

    private BeneficiarioService service;
    private ContatoService contatoService;

    public BeneficiarioDTO buscarBeneficiario(String identificacao) {
        Beneficiario beneficiario = service.buscarBeneficiario(identificacao);
        return converterBeneficiarioToDTO(beneficiario);
    }

    public BeneficiarioDTO cadastrarBeneficiario(BeneficiarioCadastro dto) {
        Contato contato = contatoService.buscarContatoPorId(dto.getIdContato());
        Beneficiario beneficiario = service.cadastrarBeneficiario(dto, contato);
        return BeneficiarioMapper.INSTANCE.toBeneficiarioDTO(beneficiario, null, Objects.nonNull(contato) ? ContatoMapper.INSTANCE.toContatoDTO(contato) : null);
    }

    public void deletarBeneficiario(String identificacao) {
        service.deletarBeneficiario(identificacao);
    }

    public BeneficiarioDTO atualizarBeneficiario(String identificacao, BeneficiarioCadastro dto) {
        Beneficiario beneficiario = service.atualizarBeneficiario(identificacao, dto);
        return converterBeneficiarioToDTO(beneficiario);
    }

    private BeneficiarioDTO converterBeneficiarioToDTO(Beneficiario beneficiario){
        ContatoDTO contatoDTO = ContatoMapper.INSTANCE.toContatoDTO(beneficiario.getContato());
        Collection<DoacaoDTO> doacoesDto = beneficiario.getDoacoesRecebidas()
                .stream()
                .map(BeneficiarioMapper.INSTANCE::toDoacaoDTO)
                .toList();
        return BeneficiarioMapper.INSTANCE.toBeneficiarioDTO(beneficiario, doacoesDto, contatoDTO);
    }
}
