package org.iftm.tds;

import java.util.ArrayList;
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
		Animal animal1 = new Animal(null, "Bidu", "Poodle", "Encaracolada", 8.5, "foto1.jpg", 2);
		Animal animal2 = new Animal(null, "Rex", "Pastor Alemão", "Curta", 25.0, "foto2.jpg", 5);
		Animal animal3 = new Animal(null, "Toby", "Poodle", "Lisa", 6.0, "foto3.jpg", 3);

		animalRepository.save(animal1);
		animalRepository.save(animal2);
		animalRepository.save(animal3);

		List<Animal> animais = animalRepository.findAll();
		System.out.println("Relatório de Animais:::::");
		for (Animal a : animais) {
			System.out.println(a.getNome() + " - " + a.getRaca());
		}

		Animal buscaAnimal = animalRepository.findById(1L).get();
		System.out.println("Busca individual (Animal):");
		System.out.println(buscaAnimal.getNome());

		System.out.println("-------- Saída Animal por idade ----------");
		ArrayList<Integer> idades = new ArrayList<>();
		idades.add(2);
		idades.add(5);
		List<Animal> animaisPorIdade = animalRepository.findByIdadeIn(idades);
		System.out.println("Total: " + animaisPorIdade.size());
		for (Animal a : animaisPorIdade) {
			System.out.println(a.getNome() + " - " + a.getIdade() + " anos");
		}

		System.out.println("-------- Saída por raça e idade mínima ----------");
		List<Animal> animaisPoodle = animalRepository.findByRacaAndIdadeGreaterThanEqual("Poodle", 2);
		System.out.println("Total: " + animaisPoodle.size());
		for (Animal a : animaisPoodle) {
			System.out.println(a.getNome() + " - " + a.getRaca() + " - " + a.getIdade() + " anos");
		}
		System.out.println("-------- Busca por nome contendo 'o' ----------");
		List<Animal> animaisComNome = animalRepository.findByNomeContaining("o");
		for (Animal a : animaisComNome) {
			System.out.println(a.getNome());
		}

		System.out.println("-------- Busca por raça 'Poodle' ----------");
		List<Animal> poodles = animalRepository.findByRaca("Poodle");
		for (Animal a : poodles) {
			System.out.println(a.getNome());
		}

		System.out.println("-------- Busca por idade maior que 3 ----------");
		List<Animal> idadeMaiorQue3 = animalRepository.findByIdadeGreaterThan(3);
		for (Animal a : idadeMaiorQue3) {
			System.out.println(a.getNome() + " - " + a.getIdade());
		}

		System.out.println("-------- Busca por idade entre 2 e 4 ----------");
		List<Animal> idadeEntre2e4 = animalRepository.findByIdadeBetween(2, 4);
		for (Animal a : idadeEntre2e4) {
			System.out.println(a.getNome() + " - " + a.getIdade());
		}

		System.out.println("-------- Busca por nome e raça ----------");
		List<Animal> nomeRaca = animalRepository.findByNomeAndRaca("Toby", "Poodle");
		for (Animal a : nomeRaca) {
			System.out.println(a.getNome() + " - " + a.getRaca());
		}

		System.out.println("-------- Busca por nome OU raça ----------");
		List<Animal> nomeOuRaca = animalRepository.findByNomeOrRaca("Rex", "Poodle");
		for (Animal a : nomeOuRaca) {
			System.out.println(a.getNome() + " - " + a.getRaca());
		}
		
	}
}
