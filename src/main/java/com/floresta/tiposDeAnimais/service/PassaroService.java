package com.floresta.tiposDeAnimais.service;

import com.floresta.tiposDeAnimais.entidade.Passaro;
import com.floresta.tiposDeAnimais.repository.PassaroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassaroService {

    private PassaroRepository passaroRepository;

    public PassaroService(PassaroRepository passaroRepository) {
        this.passaroRepository = passaroRepository;
    }

    public List<Passaro> listarPassaros(){
        return passaroRepository.findAll();
    }

    public Passaro salvarPassaro(Passaro passaro){
        return passaroRepository.save(passaro);
    }

    public Passaro atualizarPassaro(Passaro passaro, Long id){
        passaro.setId(id);
        return passaroRepository.save(passaro);
    }

    public void deletarPassaro(Long id){
        passaroRepository.deleteById(id);
    }
    public Optional<Passaro> buscarPassaroPorId(Long id){
        return passaroRepository.findById(id);
    }
}
