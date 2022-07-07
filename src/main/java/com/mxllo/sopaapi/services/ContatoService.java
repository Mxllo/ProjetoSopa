package com.mxllo.sopaapi.services;

import com.mxllo.sopaapi.models.Contato;
import com.mxllo.sopaapi.repositories.ContatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ContatoService {

    private static ContatoRepository repository;

    public Contato buscarContatoPorId(String idContato) {
        if(!(idContato == null || idContato.isEmpty())) {
            UUID uuidContato = UUID.fromString(idContato);
            return repository.findById(uuidContato).orElse(null);
        }else
            return null;
    }
}
