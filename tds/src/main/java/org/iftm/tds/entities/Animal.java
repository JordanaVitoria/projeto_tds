package org.iftm.tds.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_animal")
public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "raca", nullable = false, length = 100)
    private String raca;

    @Column(name = "pelagem", nullable = false, length = 100)
    private String pelagem;

    @Column(name = "peso", nullable = false)
    private Double peso;

    @Column(name = "foto", length = 255)
    private String foto;

    @Column(name = "idade", nullable = false)
    private Integer idade;

    // Construtores
    public Animal() {
    }

    public Animal(Long id, String nome, String raca, String pelagem, Double peso, String foto, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.pelagem = pelagem;
        this.peso = peso;
        this.foto = foto;
        this.idade = idade;

    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPelagem() {
        return pelagem;
    }

    public void setPelagem(String pelagem) {
        this.pelagem = pelagem;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getIdade() {
        return idade;
    }
    
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
