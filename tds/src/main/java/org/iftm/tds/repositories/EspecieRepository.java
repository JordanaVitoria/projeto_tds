package org.iftm.tds.repositories;

import org.iftm.tds.entities.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long> {

    // Consulta por nome da espécie
    Especie findByNome(String nome);
}
