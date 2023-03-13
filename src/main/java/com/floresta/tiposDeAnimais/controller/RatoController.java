package com.floresta.tiposDeAnimais.controller;

import com.floresta.tiposDeAnimais.entidade.Rato;
import com.floresta.tiposDeAnimais.service.RatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rato")
public class RatoController {

    private RatoService ratoService;

    public RatoController(RatoService ratoService) {
        this.ratoService = ratoService;
    }

    @GetMapping("/listar-ratos")
    @ResponseStatus(HttpStatus.OK)
    public List<Rato> listarRato(){
       return ratoService.listarRato();
    }

    @PostMapping("/salvar-rato")
    public ResponseEntity<Rato> salvarRato(@RequestBody Rato rato){

        Rato ratoSalvo = ratoService.salvarRato(rato);
        return ResponseEntity.status(HttpStatus.CREATED).body(rato);

    }

    @PutMapping("/atualizar-rato/{id}")
    public ResponseEntity<Rato> atualizarRato(@RequestBody Rato rato, @PathVariable Long id){
        Optional<Rato> ratoExiste = ratoService.buscarRatoPorId(id);

        if (!ratoExiste.isPresent()){
           return ResponseEntity.notFound().build();
        }
        Rato ratoAtualizado = ratoService.atualizarRato(rato,id);
        return ResponseEntity.status(HttpStatus.OK).body(ratoAtualizado);
    }

    @DeleteMapping("/deletar-rato/{id}")
    public ResponseEntity<Void> deletarRato(@PathVariable Long id){
        Optional<Rato> ratoExiste = ratoService.buscarRatoPorId(id);

        if (!ratoExiste.isPresent()){
           return ResponseEntity.notFound().build();
        }

        ratoService.deletarRato(id);
        return ResponseEntity.noContent().build();
    }
}
