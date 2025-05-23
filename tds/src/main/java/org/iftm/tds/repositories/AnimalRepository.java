package org.iftm.tds.repositories;

import java.util.List;

import org.iftm.tds.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    // Consulta por idade
    List<Animal> findByIdadeIn(List<Integer> idades);

    // Consulta por raça e idade maior ou igual
    List<Animal> findByRacaAndIdadeGreaterThanEqual(String raca, int idade);

    // Busca por nome (busca parcial - like)
    List<Animal> findByNomeContaining(String nome);

    // Consulta por raça (exata)
    List<Animal> findByRaca(String raca);

    // Consulta por idade maior que
    List<Animal> findByIdadeGreaterThan(int idade);

    // Consulta por idade entre valores
    List<Animal> findByIdadeBetween(int min, int max);

    // Retorna uma lista de animais cujo nome E raça correspondem exatamente aos valores fornecidos
    List<Animal> findByNomeAndRaca(String nome, String raca);

    // Retorna uma lista de animais cujo nome OU raça correspondem aos valores fornecidos
    List<Animal> findByNomeOrRaca(String nome, String raca);
}
