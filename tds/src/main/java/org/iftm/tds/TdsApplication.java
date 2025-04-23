package org.iftm.tds;

import java.util.List;

import org.iftm.tds.entities.Client;
import org.iftm.tds.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*  modifiquei a classe incluindo a implementação da interface
  commandLineRunner que permite inserir código a ser executado na
  inicialização do servidor.
 */

@SpringBootApplication
public class TdsApplication implements CommandLineRunner {
	//injeção de dependencia da classe ClientRepository.
	//permite ao SpringBoot instanciar objetos dessa classe.
	@Autowired
	private ClientRepository repositorio;	

	public static void main(String[] args) {
		SpringApplication.run(TdsApplication.class, args);
	}
	@Override
 	public void run(String... args) throws Exception {
 		
 
 		//Instanciar um objeto da classe Client
 		Client cliente = new Client();		
 		cliente.setName("Ana");
 		cliente.setCpf("000111222-22");
 		cliente.setTelefone("3499999999");
 		cliente.setQtdAnimals(3);
 		cliente.setEndereco("Av Espanha");
 		repositorio.save(cliente);
 
		//Client(Long id, String name, String cpf, Integer qtdAnimals, String telefone, String endereco)
 		Client cliente2 = new Client(null, "João", "000111232-22", 3,"3499999989" , "Av Europa");
 		repositorio.save(cliente2);
 
 		cliente2.setName("Maria");
 		repositorio.save(cliente2);
 
 		//repositorio.deleteAll();
 		//repositorio.deleteById(2L);
 		List<Client> clientes = repositorio.findAll();
 		System.out.println("Relatório:::::");
 		for (int i = 0; i < clientes.size(); i++) {
 			System.out.println(clientes.get(i).getName());
 		}
 
 		// utilizando o método de busca por id, que é a chave primaria, ou seja,
 		// retorna apenas um elemento
 		// ele retorna um objeto Optional, o metodo get() retorna o Client
 		Client busca = repositorio.findById(2L).get();
 		System.out.println("Busca individual:");
 		System.out.println(busca.getName());
 	}
 
 

}
