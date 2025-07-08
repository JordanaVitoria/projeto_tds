package org.iftm.tds.service;

import java.util.List;

import org.iftm.tds.entities.Especie;
import org.iftm.tds.repositories.EspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EspecieService {

    @Autowired
    private EspecieRepository especieRepository;

    @Transactional(readOnly = true)
    public List<Especie> findAll() {
        return especieRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Especie findById(Long id) {
        return especieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Espécie não encontrada"));
    }

    @Transactional
    public Especie insert(Especie especie) {
        return especieRepository.save(especie);
    }

    @Transactional
    public void deleteById(Long id) {
        especieRepository.deleteById(id);
    }
}
