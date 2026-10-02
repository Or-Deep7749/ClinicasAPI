package com.example.api.clinicas.service;

import com.example.api.clinicas.model.PetModel;
import com.example.api.clinicas.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    public List<PetModel> listarTodos(){
        return petRepository.findAll();
    }

    public PetModel salvar(PetModel petModel){
        return petRepository.save(petModel);
    }

    public PetModel atualizar(Long id, PetModel petModel) {
        Optional<PetModel> petExistente = petRepository.findById(id);
        if (petExistente.isPresent()) {
            petModel.setId(id);
            return petRepository.save(petModel);
        } else {
            throw new RuntimeException("Bichinho não encontrado com o ID: " + id);
        }
    }

    public void deletar(Long id) {
        petRepository.deleteById(id);
    }
}
