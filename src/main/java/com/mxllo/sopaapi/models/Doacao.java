package com.mxllo.sopaapi.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "estoque")
public class Doacao {
    @Id
    @Column
    @Type(type = "uuid-char")
    private UUID id;
    private String nomeItem;
    private Long quantidade;
    @ManyToOne
    @JoinColumn(name = "doador_id")
    private Doador doador;

    public Doacao(String nomeItem, Long quantidade, Doador doador) {
        this.id = UUID.randomUUID();
        this.nomeItem = nomeItem;
        this.quantidade = quantidade;
        this.doador = doador;
    }
}
