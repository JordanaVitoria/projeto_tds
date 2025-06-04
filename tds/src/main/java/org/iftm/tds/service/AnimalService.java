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

    // Validação
    private void validarAnimal(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Animal não pode ser nulo.");
        }
        if (animal.getNome() == null || animal.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do animal é obrigatório.");
        }
        if (animal.getRaca() == null || animal.getRaca().trim().isEmpty()) {
            throw new IllegalArgumentException("Raça do animal é obrigatória.");
        }
    }

    // Criar novo animal
    public Animal criarAnimal(Animal animal) {
        validarAnimal(animal); // Validando dados obrigatórios
        return animalRepository.save(animal);
    }

    // Atualizar animal
    public Animal atualizarAnimal(Long id, Animal animal) {
        Animal animalExistente = animalRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Animal não encontrado: " + id));

        validarAnimal(animal); // Valida dados de entrada

        animalExistente.setNome(animal.getNome());
        animalExistente.setRaca(animal.getRaca());
        animalExistente.setPelagem(animal.getPelagem());
        animalExistente.setPeso(animal.getPeso());
        animalExistente.setFoto(animal.getFoto());
        animalExistente.setIdade(animal.getIdade());

        return animalRepository.save(animalExistente);
    }

    // Deletar animal
    public void deletarAnimal(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new IllegalArgumentException("Animal com ID " + id + " não encontrado.");
        }
        animalRepository.deleteById(id);
    }
}
