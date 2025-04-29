package org.iftm.tds;

import java.util.List;

import org.iftm.tds.entities.Animal;
import org.iftm.tds.entities.Client;
import org.iftm.tds.repositories.AnimalRepository;
import org.iftm.tds.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TdsApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository repositorio;

	@Autowired
	private AnimalRepository animalRepository;

	public static void main(String[] args) {
		SpringApplication.run(TdsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// CLIENTES
		Client cliente = new Client(null, "Ana", "000111222-22", 3, "3499999999", "Av Espanha");
		repositorio.save(cliente);

		Client cliente2 = new Client(null, "João", "000111232-22", 3, "3499999989", "Av Europa");
		repositorio.save(cliente2);

		cliente2.setName("Maria");
		repositorio.save(cliente2);

		List<Client> clientes = repositorio.findAll();
		System.out.println("Relatório de Clientes:::::");
		for (Client c : clientes) {
			System.out.println(c.getName());
		}

		Client busca = repositorio.findById(2L).get();
		System.out.println("Busca individual (Client):");
		System.out.println(busca.getName());

		// ANIMAIS
		Animal animal1 = new Animal(null, "Bidu", "Poodle", "Encaracolada", 8.5, "foto1.jpg");
		Animal animal2 = new Animal(null, "Rex", "Pastor Alemão", "Curta", 25.0, "foto2.jpg");

		animalRepository.save(animal1);
		animalRepository.save(animal2);

		List<Animal> animais = animalRepository.findAll();
		System.out.println("Relatório de Animais:::::");
		for (Animal a : animais) {
			System.out.println(a.getNome() + " - " + a.getRaca());
		}

		Animal buscaAnimal = animalRepository.findById(1L).get();
		System.out.println("Busca individual (Animal):");
		System.out.println(buscaAnimal.getNome());
	}
}
