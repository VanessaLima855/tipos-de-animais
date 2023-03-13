package com.floresta.tiposDeAnimais.repository;

import com.floresta.tiposDeAnimais.entidade.Rato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatoRepository extends JpaRepository<Rato, Long> {
}
