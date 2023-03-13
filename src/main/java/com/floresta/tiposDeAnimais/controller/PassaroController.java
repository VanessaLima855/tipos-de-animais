package com.floresta.tiposDeAnimais.controller;

import com.floresta.tiposDeAnimais.entidade.Passaro;
import com.floresta.tiposDeAnimais.service.PassaroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passaro")
public class PassaroController {

    private PassaroService passaroService;

    public PassaroController(PassaroService passaroService) {
        this.passaroService = passaroService;
    }

    @GetMapping("/listar-passaros")
    @ResponseStatus(HttpStatus.OK)
    public List<Passaro> listarPassaros(){
        return passaroService.listarPassaros();

    }

    @PostMapping("/salvar-passaro")
    public ResponseEntity<Passaro> salvarPassaro(@RequestBody Passaro passaro){
        Passaro passaroSalvo = passaroService.salvarPassaro(passaro);
        return ResponseEntity.status(HttpStatus.CREATED).body(passaro);
    }

    @PutMapping("/atualizar-passaro/{id}")
    public ResponseEntity<Passaro> atualizarPassaro(@RequestBody Passaro passaro, @PathVariable Long id){
        Optional<Passaro> passaroExiste = passaroService.buscarPassaroPorId(id);

        if (!passaroExiste.isPresent()){
            ResponseEntity.notFound().build();
        }

        Passaro passaroAtualizado = passaroService.atualizarPassaro(passaro,id);
        return ResponseEntity.status(HttpStatus.OK).body(passaroAtualizado);

    }

    @DeleteMapping("/deletar-passaro/{id}")
    public void deletarPassaro(@PathVariable Long id){
        Optional<Passaro> passaroExiste = passaroService.buscarPassaroPorId(id);

        if (!passaroExiste.isPresent()){
            ResponseEntity.notFound().build();
        }

        passaroService.deletarPassaro(id);
        ResponseEntity.noContent().build();
    }

}
