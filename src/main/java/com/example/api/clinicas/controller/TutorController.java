package com.example.api.clinicas.controller;

import com.example.api.clinicas.model.TutorModel;
import com.example.api.clinicas.service.TutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutores")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService){
        this.tutorService = tutorService;
    }

    @GetMapping
    public ResponseEntity<List<TutorModel>> listarTodos(){
        List<TutorModel> tutores = tutorService.listarTodos();
        return ResponseEntity.ok(tutores);
    }

    @PostMapping
    public ResponseEntity <TutorModel> criar(@RequestBody TutorModel tutorModel){
        TutorModel novoTutor = tutorService.salvar(tutorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTutor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorModel> atualizar(@PathVariable Long id, @RequestBody TutorModel tutorModel){
        TutorModel atualizada = tutorService.atualizar(id, tutorModel);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        tutorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
