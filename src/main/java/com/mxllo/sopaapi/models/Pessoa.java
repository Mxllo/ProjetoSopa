package com.mxllo.sopaapi.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "pessoas", indexes = {
        @Index(name = "idx_pessoa_cpf", columnList = "cpf"),
        @Index(name = "idx_pessoa_rg", columnList = "rg")
})
public class Pessoa {
    @Id
    @Column
    @Type(type = "uuid-char")
    private UUID id = UUID.randomUUID();
    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private String rg;
    @Column
    private LocalDate dataDeNascimento;
    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "contato_id")
    @Nullable
    private Contato contato;


    public Pessoa(String nome, String cpf, String rg, LocalDate dataDeNascimento, @Nullable Contato contato) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataDeNascimento = dataDeNascimento;
        this.contato = contato;
    }
}
