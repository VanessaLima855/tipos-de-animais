package com.floresta.tiposDeAnimais.controller;

import com.floresta.tiposDeAnimais.entidade.Inseto;
import com.floresta.tiposDeAnimais.service.InsetoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inseto")
public class InsetoController {
    private InsetoService insetoService;

    public InsetoController(InsetoService insetoService) {
        this.insetoService = insetoService;
    }

    @GetMapping("/listar-insetos")
    @ResponseStatus(HttpStatus.OK)
    public List<Inseto> listarInsetos(){
        return insetoService.listarInsetos();
    }

    @PostMapping("/salvar-inseto")
    public ResponseEntity<Inseto> salvarInseto(@RequestBody Inseto inseto){
        Inseto insetoSalvo = insetoService.salvarInseto(inseto);
        return ResponseEntity.status(HttpStatus.CREATED).body(inseto);
    }
}
