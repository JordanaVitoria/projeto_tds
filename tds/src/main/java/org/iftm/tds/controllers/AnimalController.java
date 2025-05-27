package org.iftm.tds.controllers;

import java.util.List;

import org.iftm.tds.entities.Animal;
import org.iftm.tds.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    // Endpoint para buscar por nome E raça
    @GetMapping("/buscar-nome-e-raca")
    public List<Animal> buscarPorNomeERaca(
            @RequestParam String nome,
            @RequestParam String raca) {
        return animalService.buscarPorNomeERaca(nome, raca);
    }

    // Endpoint para buscar por nome OU raça
    @GetMapping("/buscar-nome-ou-raca")
    public List<Animal> buscarPorNomeOuRaca(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String raca) {
        return animalService.buscarPorNomeOuRaca(nome, raca);
    }
}
