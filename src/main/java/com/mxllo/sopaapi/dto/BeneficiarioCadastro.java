package com.mxllo.sopaapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BeneficiarioCadastro {
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("cpf")
    private String cpf;
    @JsonProperty("rg")
    private String rg;
    @JsonProperty("data_de_nascimento")
    private String dataDeNascimento;
    @JsonProperty("id_contato")
    private String idContato;
}
