package org.iftm.tds.entities;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="tb_client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private Integer qtdAnimals;
    private Integer telefone;
    private Integer endereco;
    
// Construtores, getters e setters

public Client(Long id, String name, String cpf, Integer qtdAnimals, Integer telefone, Integer endereco) {
    this.id = id;
    this.name = name;
    this.cpf = cpf;
    this.endereco = endereco;
    this.qtdAnimals = qtdAnimals;
    this.telefone = telefone;

}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getCpf() {
    return cpf;
}
public void setCpf(String cpf) {
    this.cpf = cpf;
}
public Integer getEndereco() {
    return endereco;
}
public void setEndereco(Integer endereco) {
    this.endereco = endereco;
}
public Integer getQtdAnimals() {
    return qtdAnimals;
}
public void setQtdAnimals(Integer qtdAnimals) {
    this.qtdAnimals = qtdAnimals;
}
public Integer getTelefone() {
    return telefone;
}
public void setTelefone(Integer telefone) {
    this.telefone = telefone;
}
}

