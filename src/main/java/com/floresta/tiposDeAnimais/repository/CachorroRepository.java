package com.floresta.tiposDeAnimais.repository;

import com.floresta.tiposDeAnimais.entidade.Cachorro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CachorroRepository extends JpaRepository<Cachorro, Long> {
}
