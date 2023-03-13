package com.floresta.tiposDeAnimais.service;

import com.floresta.tiposDeAnimais.entidade.Cachorro;
import com.floresta.tiposDeAnimais.repository.CachorroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CachorroService {

    private CachorroRepository cachorroRepository;

    public CachorroService(CachorroRepository cachorroRepository) {
        this.cachorroRepository = cachorroRepository;
    }

    public List<Cachorro> listarCachorros(){
        return cachorroRepository.findAll();
    }

    public Cachorro salvarCachorro(Cachorro cachorro){
        return cachorroRepository.save(cachorro);
    }

    public Cachorro atualizarCachorro(Cachorro cachorro, Long id){
        cachorro.setId(id);
        return cachorroRepository.save(cachorro);
    }

    public void deletarCachorro(Long id){
        cachorroRepository.deleteById(id);
    }

    public Optional<Cachorro> buscarCachorroPorId(Long id){
       return cachorroRepository.findById(id);
    }

}
