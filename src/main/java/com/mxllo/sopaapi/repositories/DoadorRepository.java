package com.mxllo.sopaapi.repositories;

import com.mxllo.sopaapi.models.Doador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoadorRepository extends JpaRepository<Doador, UUID> {
}
