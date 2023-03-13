package com.floresta.tiposDeAnimais.controller;

import com.floresta.tiposDeAnimais.entidade.Gato;
import com.floresta.tiposDeAnimais.service.GatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gato")
public class GatoController {
    private GatoService gatoService;

    public GatoController(GatoService gatoService) {
        this.gatoService = gatoService;
    }

    @GetMapping("/listar-gatos")
    @ResponseStatus(HttpStatus.OK)
    public List<Gato> listarGatos(){
        return gatoService.listarGatos();
    }

    @PostMapping("/salvar-gato")
    public ResponseEntity<Gato> salvarGato(@RequestBody Gato gato){
        Gato gatoSalvo = gatoService.salvarGato(gato);
        return ResponseEntity.status(HttpStatus.CREATED).body(gato);
    }

    @PutMapping("/atualizar-gato/{id}")
    public ResponseEntity<Gato> atualizarGato(@RequestBody Gato gato, @PathVariable Long id){
        Optional<Gato> gatoExite = gatoService.buscarGatoPorId(id);

        if (!gatoExite.isPresent()){
         return    ResponseEntity.notFound().build();
        }

        Gato gatoAtualizado = gatoService.atualizarGato(gato,id);
        return ResponseEntity.status(HttpStatus.OK).body(gatoAtualizado);
    }

    @DeleteMapping("deletar-gato/{id}")
    public ResponseEntity<Void> deletarGato(@PathVariable Long id){
        Optional<Gato> gatoExiste = gatoService.buscarGatoPorId(id);

        if (!gatoExiste.isPresent()){
          return ResponseEntity.notFound().build();
        }
        gatoService.deletarGato(id);
       return ResponseEntity.noContent().build();
    }

}
