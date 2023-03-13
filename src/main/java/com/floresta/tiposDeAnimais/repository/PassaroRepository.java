package com.floresta.tiposDeAnimais.repository;

import com.floresta.tiposDeAnimais.entidade.Passaro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassaroRepository extends JpaRepository<Passaro,Long> {
}
