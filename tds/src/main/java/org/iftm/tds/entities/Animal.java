package org.iftm.tds.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_animal")
public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @ManyToOne(optional = false)
    @JoinColumn(name = "especie_id", nullable = false)
    private Especie especie;

    @Column(nullable = false, length = 100)
    private String pelagem;

    @Column(nullable = false)
    private Double peso;

    private String foto;

    @Column(nullable = false)
    private Integer idade;

    // Construtor vazio
    public Animal() {
    }

    // Construtor com todos os atributos
    public Animal(Long id, String nome, Especie especie, String pelagem, Double peso, String foto, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.pelagem = pelagem;
        this.peso = peso;
        this.foto = foto;
        this.idade = idade;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Especie getEspecie() { return especie; }
    public void setEspecie(Especie especie) { this.especie = especie; }

    public String getPelagem() { return pelagem; }
    public void setPelagem(String pelagem) { this.pelagem = pelagem; }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }

    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }

    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }

    @Override
    public String toString() {
        return "Animal [id=" + id + ", nome=" + nome + ", especie=" + especie + ", pelagem=" + pelagem + ", peso=" + peso
                + ", foto=" + foto + ", idade=" + idade + "]";
    }
}
