package com.floresta.tiposDeAnimais.repository;

import com.floresta.tiposDeAnimais.entidade.Gato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatoRepository extends JpaRepository<Gato,Long> {
}
