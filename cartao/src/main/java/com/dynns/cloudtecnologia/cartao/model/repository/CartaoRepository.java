package com.dynns.cloudtecnologia.cartao.model.repository;

import com.dynns.cloudtecnologia.cartao.model.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {
}
