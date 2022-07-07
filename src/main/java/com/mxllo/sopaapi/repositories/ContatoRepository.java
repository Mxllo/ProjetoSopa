package com.mxllo.sopaapi.repositories;

import com.mxllo.sopaapi.models.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContatoRepository extends JpaRepository<Contato, UUID> {
}
