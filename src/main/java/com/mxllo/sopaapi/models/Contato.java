package com.mxllo.sopaapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Table(name = "contatos")
@NoArgsConstructor
public class Contato {
    @Id
    @Column
    @Type(type = "uuid-char")
    private UUID id;
    @Column
    private String email;
    @ElementCollection
    @Column
    private Set<Long> telefones;
    @Nullable
    @Column
    private String instagram;
    @Nullable
    @Column
    private String facebook;
    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "contato")
    private Pessoa pessoa;

    public Contato(String email, Set<Long> telefones, @Nullable String instagram, @Nullable String facebook) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.telefones = telefones;
        this.instagram = instagram;
        this.facebook = facebook;
    }
}
