package com.floresta.tiposDeAnimais.service;

import com.floresta.tiposDeAnimais.entidade.Rato;
import com.floresta.tiposDeAnimais.repository.RatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatoService {

    public RatoRepository ratoRepository;

    public RatoService(RatoRepository ratoRepository) {
        this.ratoRepository = ratoRepository;
    }

    public List<Rato> listarRato(){
        return ratoRepository.findAll();
    }

    public Rato salvarRato(Rato rato){
        return ratoRepository.save(rato);
    }

    public Rato atualizarRato(Rato rato, Long id){
        rato.setId(id);
        return ratoRepository.save(rato);
    }

    public void deletarRato(Long id){
        ratoRepository.deleteById(id);
    }

    public Optional<Rato> buscarRatoPorId(Long id){
        return ratoRepository.findById(id);
    }
}
