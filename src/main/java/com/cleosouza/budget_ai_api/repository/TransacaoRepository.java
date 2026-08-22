package com.cleosouza.budget_ai_api.repository;

import com.cleosouza.budget_ai_api.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
