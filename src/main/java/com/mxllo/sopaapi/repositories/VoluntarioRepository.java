package com.mxllo.sopaapi.repositories;

import com.mxllo.sopaapi.models.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VoluntarioRepository extends JpaRepository<Voluntario, UUID> {
}
