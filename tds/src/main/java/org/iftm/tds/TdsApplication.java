package org.iftm.tds;

import java.util.List;

import org.iftm.tds.entities.Animal;
import org.iftm.tds.entities.Client;
import org.iftm.tds.entities.Especie;
import org.iftm.tds.repositories.AnimalRepository;
import org.iftm.tds.repositories.ClientRepository;
import org.iftm.tds.repositories.EspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TdsApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private EspecieRepository especieRepository;

    public static void main(String[] args) {
        SpringApplication.run(TdsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // CLIENTES
        Client cliente1 = new Client(null, "Ana", "000111222-22", 3, "3499999999", "Av Espanha");
        Client cliente2 = new Client(null, "João", "000111232-22", 2, "3499999989", "Av Europa");
        Client cliente3 = new Client(null, "Maria", "000111244-22", 1, "3499999977", "Av Brasil");

        clientRepository.save(cliente1);
        clientRepository.save(cliente2);
        clientRepository.save(cliente3);

        System.out.println("Relatório de Clientes:");
        List<Client> clientes = clientRepository.findAll();
        for (Client c : clientes) {
            System.out.println(c.getName());
        }

        // ESPÉCIES
        Especie especie1 = new Especie(null, "Poodle");
        Especie especie2 = new Especie(null, "Pastor Alemão");
        especieRepository.save(especie1);
        especieRepository.save(especie2);

        // ANIMAIS
        Animal animal1 = new Animal(null, "Bidu", especie1, "Encaracolada", 8.5, "foto1.jpg", 3);
        Animal animal2 = new Animal(null, "Rex", especie2, "Curta", 25.0, "foto2.jpg", 5);
        Animal animal3 = new Animal(null, "Luna", especie1, "Lisa", 7.0, "foto3.jpg", 2);

        animalRepository.save(animal1);
        animalRepository.save(animal2);
        animalRepository.save(animal3);

        System.out.println("Relatório de Animais:");
        List<Animal> animais = animalRepository.findAll();
        for (Animal a : animais) {
            System.out.println(a.getNome() + " - " + a.getEspecie().getNome());
        }

        System.out.println("Relatório de Espécies:");
        List<Especie> especies = especieRepository.findAll();
        for (Especie e : especies) {
            System.out.println(e.getNome());
        }
    }
}
