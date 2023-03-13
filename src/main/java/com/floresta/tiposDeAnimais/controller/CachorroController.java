package com.floresta.tiposDeAnimais.controller;

import com.floresta.tiposDeAnimais.entidade.Cachorro;
import com.floresta.tiposDeAnimais.service.CachorroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cachorro")
public class CachorroController {

    private CachorroService cachorroService;

    public CachorroController(CachorroService cachorroService) {
        this.cachorroService = cachorroService;
    }

    @GetMapping("/listar-cachorros")
    @ResponseStatus(HttpStatus.OK)
    public List<Cachorro> listarCachorros(){
        return cachorroService.listarCachorros();
    }

    @PostMapping("/salvar-cachorro")
    public ResponseEntity<Cachorro> salvarCachorro(@RequestBody Cachorro cachorro){
        Cachorro cachorroSalvo = cachorroService.salvarCachorro(cachorro);
        return ResponseEntity.status(HttpStatus.CREATED).body(cachorro);
    }

    @PutMapping("/atualizar-cachorro/{id}")
    public ResponseEntity<Cachorro> atualizarCachorro(@RequestBody Cachorro cachorro,@PathVariable Long id){
        Optional<Cachorro> cachorroExiste = cachorroService.buscarCachorroPorId(id);

        if (!cachorroExiste.isPresent()) {
            return ResponseEntity.notFound().build();

        }

        Cachorro cachorroAtualizado = cachorroService.atualizarCachorro(cachorro,id);
        return ResponseEntity.status(HttpStatus.OK).body(cachorroAtualizado);
    }

    @DeleteMapping("deletar-cachorro/{id}")
    public void deletarCachorro(@PathVariable Long id){
        Optional<Cachorro> cachorroExiste = cachorroService.buscarCachorroPorId(id);

        if (!cachorroExiste.isPresent()){
            ResponseEntity.notFound().build();
        }

        cachorroService.deletarCachorro(id);
        ResponseEntity.noContent().build();
    }





}
