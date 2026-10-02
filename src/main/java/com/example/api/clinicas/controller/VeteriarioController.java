package com.example.api.clinicas.controller;

import com.example.api.clinicas.model.PetModel;
import com.example.api.clinicas.model.VeterinarioModel;
import com.example.api.clinicas.service.VeterinarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
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

    @PutMapping("/{id}")
    public ResponseEntity<VeterinarioModel> atualizar(@PathVariable Long id, @RequestBody VeterinarioModel veterinarioModel){
        VeterinarioModel atualizada = veterinarioService.atualizar(id, veterinarioModel);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        veterinarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
