package com.floresta.tiposDeAnimais.service;

import com.floresta.tiposDeAnimais.entidade.Inseto;
import com.floresta.tiposDeAnimais.repository.InsetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InsetoService {
    private InsetoRepository insetoRepository;

    public InsetoService(InsetoRepository insetoRepository) {
        this.insetoRepository = insetoRepository;
    }

    public List<Inseto> listarInsetos(){
        return insetoRepository.findAll();
    }

    public Inseto salvarInseto(Inseto inseto){
        return insetoRepository.save(inseto);
    }
}
