package com.mxllo.sopaapi.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Voluntario extends Pessoa{
    private LocalDate dataDeInicio;
    private LocalDate dataDeSaida;
    //@ElementCollection
    //private Set<DiaDaSemana> diasDisponiveis;
    private Cargo cargo;
    private String profissao;

    public Voluntario(String nome, String cpf, String rg, LocalDate dataDeNascimento, Contato contato, LocalDate dataDeInicio, LocalDate dataDeSaida, Cargo cargo, String profissao) {
        super(nome, cpf, rg, dataDeNascimento, contato);
        this.dataDeInicio = dataDeInicio;
        this.dataDeSaida = dataDeSaida;
        //this.diasDisponiveis = diasDisponiveis;
        this.cargo = cargo;
        this.profissao = profissao;
    }
}
