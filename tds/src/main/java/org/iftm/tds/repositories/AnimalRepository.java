package org.iftm.tds.repositories;

import java.util.List;

import org.iftm.tds.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByNomeAndEspecieNome(String nome, String especieNome);

    List<Animal> findByNomeOrEspecieNome(String nome, String especieNome);

    List<Animal> findByIdadeGreaterThan(int idade);

    List<Animal> findByIdadeBetween(int min, int max);

    List<Animal> findByEspecieNomeAndIdadeGreaterThanEqual(String especieNome, int idade);
}
