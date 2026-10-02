package com.example.api.clinicas.service;

import com.example.api.clinicas.model.PetModel;
import com.example.api.clinicas.model.VeterinarioModel;
import com.example.api.clinicas.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioService(VeterinarioRepository veterinarioRepository){
        this.veterinarioRepository = veterinarioRepository;
    }

    public List<VeterinarioModel> listarTodos(){
        return veterinarioRepository.findAll();
    }

    public VeterinarioModel salvar(VeterinarioModel veterinarioModel){
        return veterinarioRepository.save(veterinarioModel);
    }

    public VeterinarioModel atualizar(Long id, VeterinarioModel veterinarioModel) {
        Optional<VeterinarioModel> veterinarioExistente = veterinarioRepository.findById(id);
        if (veterinarioExistente.isPresent()) {
            veterinarioModel.setId(id);
            return veterinarioRepository.save(veterinarioModel);
        } else {
            throw new RuntimeException("Veterinário não encontrado com o ID: " + id);
        }
    }

    public void deletar(Long id) {
        veterinarioRepository.deleteById(id);
    }
}
