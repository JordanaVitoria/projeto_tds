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

    // Consulta por nome E espécie (raça)
    @Transactional(readOnly = true)
public List<Animal> buscarPorNomeEEspecie(String nome, String especieNome) {
    if (nome == null || nome.trim().isEmpty() || especieNome == null || especieNome.trim().isEmpty()) {
        throw new IllegalArgumentException("Nome e espécie devem ser preenchidos.");
    }
    return animalRepository.findByNomeAndEspecieNome(nome, especieNome);
}


    // Consulta por nome OU espécie (raça)
    @Transactional(readOnly = true)
    public List<Animal> buscarPorNomeOuEspecie(String nome, String especieNome) {
        if ((nome == null || nome.trim().isEmpty()) && (especieNome == null || especieNome.trim().isEmpty())) {
            throw new IllegalArgumentException("Pelo menos nome ou espécie devem ser preenchidos.");
        }
        return animalRepository.findByNomeOrEspecieNome(nome, especieNome);
    }

    // Validação de campos obrigatórios
    private void validarAnimal(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Animal não pode ser nulo.");
        }
        if (animal.getNome() == null || animal.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do animal é obrigatório.");
        }
        if (animal.getEspecie() == null) {
            throw new IllegalArgumentException("Espécie do animal é obrigatória.");
        }
    }

    // Inserção de um animal com validação
    @Transactional
    public Animal criarAnimal(Animal animal) {
        validarAnimal(animal);
        return animalRepository.save(animal);
    }

    // Atualização de dados de um animal existente
    @Transactional
    public Animal atualizarAnimal(Long id, Animal animal) {
        Animal animalExistente = animalRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Animal não encontrado: " + id));

        validarAnimal(animal);

        animalExistente.setNome(animal.getNome());
        animalExistente.setEspecie(animal.getEspecie());
        animalExistente.setPelagem(animal.getPelagem());
        animalExistente.setPeso(animal.getPeso());
        animalExistente.setFoto(animal.getFoto());
        animalExistente.setIdade(animal.getIdade());

        return animalRepository.save(animalExistente);
    }

    // Remoção de um animal por ID
    @Transactional
    public void deletarAnimal(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new IllegalArgumentException("Animal com ID " + id + " não encontrado.");
        }
        animalRepository.deleteById(id);
    }

    // Consulta por ID
    @Transactional(readOnly = true)
    public Animal buscarPorId(Long id) {
        return animalRepository.findById(id).orElse(null);
    }

    // Retorna todos os animais
    @Transactional(readOnly = true)
    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    // Consulta por idade maior que
    @Transactional(readOnly = true)
    public List<Animal> buscarPorIdadeMaiorQue(int idade) {
        return animalRepository.findByIdadeGreaterThan(idade);
    }

    // Consulta por intervalo de idades
    @Transactional(readOnly = true)
    public List<Animal> buscarPorIdadeEntre(int min, int max) {
        return animalRepository.findByIdadeBetween(min, max);
    }

    // Consulta por espécie (raça) e idade mínima
    @Transactional(readOnly = true)
    public List<Animal> buscarPorEspecieEIdadeMinima(String especieNome, int idade) {
        return animalRepository.findByEspecieNomeAndIdadeGreaterThanEqual(especieNome, idade);
    }
}
