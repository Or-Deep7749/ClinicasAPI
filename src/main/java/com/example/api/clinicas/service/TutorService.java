package com.example.api.clinicas.service;

import com.example.api.clinicas.model.TutorModel;
import com.example.api.clinicas.repository.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository){
        this.tutorRepository = tutorRepository;
    }

    public List<TutorModel> listarTodos(){
        return tutorRepository.findAll();
    }

    public TutorModel salvar(TutorModel tutor){
        return tutorRepository.save(tutor);
    }

    public TutorModel atualizar(Long id, TutorModel tutorModel) {
        Optional<TutorModel> tutorExistente = tutorRepository.findById(id);
        if (tutorExistente.isPresent()) {
            tutorModel.setId(id);
            return tutorRepository.save(tutorModel);
        } else {
            throw new RuntimeException("Tutor não encontrado com o ID: " + id);
        }
    }

    public void deletar(Long id) {
        tutorRepository.deleteById(id);
    }
}
