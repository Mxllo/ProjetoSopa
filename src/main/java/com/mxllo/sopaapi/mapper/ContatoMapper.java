package com.mxllo.sopaapi.mapper;

import com.mxllo.sopaapi.dto.ContatoDTO;
import com.mxllo.sopaapi.models.Contato;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ContatoMapper {
    ContatoMapper INSTANCE = Mappers.getMapper(ContatoMapper.class);

    ContatoDTO toContatoDTO(Contato contato);
}
