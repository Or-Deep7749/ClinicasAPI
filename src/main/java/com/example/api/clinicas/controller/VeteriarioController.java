package com.example.api.clinicas.controller;

import com.example.api.clinicas.model.VeterinarioModel;
import com.example.api.clinicas.service.VeterinarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
@CrossOrigin(origins = "http://localhost:3000")
public class VeteriarioController {

    private final VeterinarioService veterinarioService;

    public VeteriarioController(VeterinarioService veterinarioService){
        this.veterinarioService = veterinarioService;
    }

    @GetMapping
    public ResponseEntity<List<VeterinarioModel>> listarTodos(){
        List<VeterinarioModel> veterinarios = veterinarioService.listarTodos();
        return ResponseEntity.ok(veterinarios);
    }

    @PostMapping
    public ResponseEntity<VeterinarioModel> criar(@RequestBody VeterinarioModel veterinarioModel){
        VeterinarioModel novoVeterinario = veterinarioService.salvar(veterinarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVeterinario);
    }
}
