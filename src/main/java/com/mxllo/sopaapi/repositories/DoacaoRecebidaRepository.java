package com.mxllo.sopaapi.repositories;

import com.mxllo.sopaapi.models.Doacao;
import com.mxllo.sopaapi.models.DoacaoRecebida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DoacaoRecebidaRepository extends JpaRepository<DoacaoRecebida, UUID> {
}
