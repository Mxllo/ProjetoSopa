package com.mxllo.sopaapi.mapper;

import com.mxllo.sopaapi.dto.BeneficiarioCadastro;
import com.mxllo.sopaapi.dto.BeneficiarioDTO;
import com.mxllo.sopaapi.dto.ContatoDTO;
import com.mxllo.sopaapi.dto.DoacaoDTO;
import com.mxllo.sopaapi.models.Beneficiario;
import com.mxllo.sopaapi.models.Contato;
import com.mxllo.sopaapi.models.DoacaoRecebida;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface BeneficiarioMapper {
    BeneficiarioMapper INSTANCE = Mappers.getMapper(BeneficiarioMapper.class);

    @Mapping(source = "doacoes", target = "doacoesRecebidas")
    @Mapping(source = "contato", target = "contatoDTO")
    BeneficiarioDTO toBeneficiarioDTO(Beneficiario beneficiario, Collection<DoacaoDTO> doacoes, ContatoDTO contato);

    DoacaoDTO toDoacaoDTO(DoacaoRecebida doacao);

    @Mapping(source = "dataDeNascimento", target = "dataDeNascimento", dateFormat = "dd/MM/yyyy")
    Beneficiario toBeneficiario(BeneficiarioCadastro dto);
}
