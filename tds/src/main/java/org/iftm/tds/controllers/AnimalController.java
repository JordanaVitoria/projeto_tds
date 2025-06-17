package org.iftm.tds.controllers;

import java.util.List;

import org.iftm.tds.entities.Animal;
import org.iftm.tds.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    //Endpoint para criar um novo animal
    @PostMapping
    public ResponseEntity<Animal> criarAnimal(@RequestBody Animal animal) {
        Animal novoAnimal = animalService.criarAnimal(animal);
        return ResponseEntity.ok(novoAnimal);
    }
    //Endpoint para atualizar animal
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Animal> atualizarAnimal(@PathVariable Long id, @RequestBody Animal animal) {
    Animal animalAtualizado = animalService.atualizarAnimal(id, animal);
    if (animalAtualizado != null) {
        return ResponseEntity.ok(animalAtualizado);
    } else {
        return ResponseEntity.notFound().build();
    }
    }
    //Endpoint para deletar animal
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarAnimal(@PathVariable Long id) {
        animalService.deletarAnimal(id);
        return ResponseEntity.noContent().build();
    }
    // Endpoint para buscar animal por ID
    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable Long id) {
        Animal animal = animalService.buscarPorId(id);
        if (animal != null) {
            return ResponseEntity.ok(animal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
