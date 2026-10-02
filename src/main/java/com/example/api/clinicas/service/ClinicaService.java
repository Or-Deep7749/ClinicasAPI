package com.example.api.clinicas.service;

import com.example.api.clinicas.model.ClinicaModel;
import com.example.api.clinicas.repository.ClinicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicaService {

    private final ClinicaRepository clinicaRepository;

    public ClinicaService(ClinicaRepository clinicaRepository){
        this.clinicaRepository = clinicaRepository;
    }

    public List<ClinicaModel> listarTodas(){
        return clinicaRepository.findAll();
    }

    public ClinicaModel salvar(ClinicaModel clinicaModel){
        return clinicaRepository.save(clinicaModel);
    }

    public ClinicaModel atualizar(Long id, ClinicaModel clinicaModel) {
        Optional<ClinicaModel> clinicaExistente = clinicaRepository.findById(id);
        if (clinicaExistente.isPresent()) {
            clinicaModel.setId(id);
            return clinicaRepository.save(clinicaModel);
        } else {
            throw new RuntimeException("Clínica não encontrada com o ID: " + id);
        }
    }

    public void deletar(Long id) {
        clinicaRepository.deleteById(id);
    }
}
