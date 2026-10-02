package com.example.api.clinicas.controller;

import com.example.api.clinicas.model.PetModel;
import com.example.api.clinicas.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService){
        this.petService = petService;
    }

    @GetMapping
    public ResponseEntity<List<PetModel>> listarTodos(){
        List<PetModel> pets = petService.listarTodos();
        return ResponseEntity.ok(pets);
    }

    @PostMapping
    public ResponseEntity<PetModel> criar(@RequestBody PetModel petModel){
        PetModel novoPet = petService.salvar(petModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetModel> atualizar(@PathVariable Long id, @RequestBody PetModel petModel){
        PetModel atualizada = petService.atualizar(id, petModel);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        petService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
