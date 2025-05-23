package org.iftm.tds.entities;


import java.io.Serializable;

import jakarta.persistence.Column;
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
    @Column(name = "id", nullable = false, length = 100)
    private Long id;
    @Column(name = "client_name", nullable = false, length = 100)
    private String name;
    @Column(name = "cpf", nullable = false, length = 100)
    private String cpf;
    @Column(name = "quantidade_animais", nullable = false, length = 100)
    private Integer qtdAnimals;
    @Column(name = "telefone", nullable = false, length = 100)
    private String telefone;
    @Column(name = "endereco", nullable = false, length = 100)
    private String endereco;
    
// Construtores, getters e setters

public Client(Long id, String name, String cpf, Integer qtdAnimals, String telefone, String endereco) {
    this.id = id;
    this.name = name;
    this.cpf = cpf;
    this.endereco = endereco;
    this.qtdAnimals = qtdAnimals;
    this.telefone = telefone;

}
public Client(){

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
public String getEndereco() {
    return endereco;
}
public void setEndereco(String endereco) {
    this.endereco = endereco;
}
public Integer getQtdAnimals() {
    return qtdAnimals;
}
public void setQtdAnimals(Integer qtdAnimals) {
    this.qtdAnimals = qtdAnimals;
}
public String getTelefone() {
    return telefone;
}
public void setTelefone(String telefone) {
    this.telefone = telefone;
}
}

