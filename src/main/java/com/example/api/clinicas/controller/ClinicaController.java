package com.example.api.clinicas.controller;

import com.example.api.clinicas.model.ClinicaModel;
import com.example.api.clinicas.service.ClinicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinicas")
@CrossOrigin(origins = "http://localhost:3000")
public class ClinicaController {

    private final ClinicaService clinicaService;

    public ClinicaController(ClinicaService clinicaService){
        this.clinicaService = clinicaService;
    }

    @GetMapping
    public ResponseEntity<List<ClinicaModel>> listarTodas(){
        List<ClinicaModel> clinicas = clinicaService.listarTodas();
        return ResponseEntity.ok(clinicas);
    }

    @PostMapping
    public ResponseEntity<ClinicaModel> criar(@RequestBody ClinicaModel clinicaModel){
        ClinicaModel novaClinica = clinicaService.salvar(clinicaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaClinica);
    }
}
