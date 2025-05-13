package org.iftm.tds.service;

import java.util.List;

import org.iftm.tds.entities.Animal;
import org.iftm.tds.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    // Buscar por nome E raça
    @Transactional(readOnly = true)
    public List<Animal> buscarPorNomeERaca(String nome, String raca) {
        if (nome == null || nome.trim().isEmpty() || raca == null || raca.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome e raça devem ser preenchidos.");
        }
        return animalRepository.findByNomeAndRaca(nome, raca);
    }

    // Buscar por nome OU raça
    @Transactional(readOnly = true)
    public List<Animal> buscarPorNomeOuRaca(String nome, String raca) {
        if ((nome == null || nome.trim().isEmpty()) && (raca == null || raca.trim().isEmpty())) {
            throw new IllegalArgumentException("Pelo menos nome ou raça devem ser preenchidos.");
        }
        return animalRepository.findByNomeOrRaca(nome, raca);
    }
}
