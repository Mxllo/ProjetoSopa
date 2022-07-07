package com.mxllo.sopaapi.services;

import com.mxllo.sopaapi.dto.BeneficiarioCadastro;
import com.mxllo.sopaapi.dto.BeneficiarioDTO;
import com.mxllo.sopaapi.dto.ContatoDTO;
import com.mxllo.sopaapi.dto.DoacaoDTO;
import com.mxllo.sopaapi.mapper.BeneficiarioMapper;
import com.mxllo.sopaapi.mapper.ContatoMapper;
import com.mxllo.sopaapi.models.Beneficiario;
import com.mxllo.sopaapi.models.Contato;
import com.mxllo.sopaapi.repositories.BeneficiarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Service
@AllArgsConstructor
@Transactional
public class BeneficiarioService {

    private final BeneficiarioRepository repository;

    public Beneficiario cadastrarBeneficiario(BeneficiarioCadastro dto, Contato contato) {
        //validar cpf, rg e data de nascimento
        validarBeneficiarioCadastrado(dto);
        Beneficiario beneficiario = BeneficiarioMapper.INSTANCE.toBeneficiario(dto);
        if(contato != null)
            beneficiario.setContato(contato);
        return repository.save(beneficiario);

    }

    private void validarBeneficiarioCadastrado(BeneficiarioCadastro dto) {
        if(repository.existsBeneficiarioByCpf(dto.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }
        if(repository.existsBeneficiarioByRg(dto.getRg())) {
            throw new IllegalArgumentException("RG já cadastrado");
        }
    }

    public Beneficiario buscarBeneficiario(String identificacao) {
        return buscarBeneficiarioPorIdentificacao(identificacao);
    }

    public void deletarBeneficiario(String identificacao) {
        if(identificacao.length() == 9)
            repository.deleteByRg(identificacao);
        else
            repository.deleteByCpf(identificacao);
    }

    public Beneficiario atualizarBeneficiario(String identificacao, BeneficiarioCadastro dto) {
        Beneficiario beneficiario = buscarBeneficiarioPorIdentificacao(identificacao);
        beneficiario.setNome(dto.getNome());
        beneficiario.setDataDeNascimento(LocalDate.parse(dto.getDataDeNascimento()));
        beneficiario.setRg(dto.getRg());
        beneficiario.setCpf(dto.getCpf());
        return repository.save(beneficiario);
    }

    public void atualizarContato(String identificaao, BeneficiarioCadastro dto, Contato contato) {
        Beneficiario beneficiario = buscarBeneficiarioPorIdentificacao(identificaao);
        beneficiario.setContato(contato);
        repository.save(beneficiario);
    }

    private Beneficiario buscarBeneficiarioPorIdentificacao(String identificacao){
        if(identificacao.length() == 9) {
            return repository.findByRg(identificacao).orElseThrow(() -> new IllegalArgumentException("Beneficiário não encontrado"));
        }else {
            return repository.findByCpf(identificacao).orElseThrow(() -> new IllegalArgumentException("Beneficiário não encontrado"));
        }
    }
}
