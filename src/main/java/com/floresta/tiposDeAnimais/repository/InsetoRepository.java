package com.floresta.tiposDeAnimais.repository;

import com.floresta.tiposDeAnimais.entidade.Inseto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsetoRepository extends JpaRepository<Inseto,Long> {
}
