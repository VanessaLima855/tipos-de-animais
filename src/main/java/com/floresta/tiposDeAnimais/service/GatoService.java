package com.floresta.tiposDeAnimais.service;

import com.floresta.tiposDeAnimais.entidade.Gato;
import com.floresta.tiposDeAnimais.repository.GatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GatoService {
    private GatoRepository gatoRepository;

    public GatoService(GatoRepository gatoRepository) {
        this.gatoRepository = gatoRepository;
    }

    public List<Gato> listarGatos(){
        return gatoRepository.findAll();
    }

    public Gato salvarGato(Gato gato){
        return gatoRepository.save(gato);
    }

    public Gato atualizarGato(Gato gato, Long id){
        gato.setId(id);
        return gatoRepository.save(gato);
    }

    public void deletarGato(Long id){
        gatoRepository.deleteById(id);
    }

    public Optional<Gato> buscarGatoPorId(Long id){
        return gatoRepository.findById(id);
    }
}
