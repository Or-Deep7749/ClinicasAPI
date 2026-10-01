package com.example.api.clinicas.controller;

import com.example.api.clinicas.model.PetModel;
import com.example.api.clinicas.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin(origins = "http://localhost:3000")
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
}
