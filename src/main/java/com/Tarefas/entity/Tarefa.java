package com.Tarefas.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "tarefas")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    private boolean realizado;
    private int prioridade;

    public Tarefa() {

    }
  
    public Tarefa(Long id, @NotBlank String nome, @NotBlank String descricao, boolean realizado, int prioridade) {
      this.id = id;
      this.nome = nome;
      this.descricao = descricao;
      this.realizado = realizado;
      this.prioridade = prioridade;
    }    

    public Tarefa(String nome, String descricao, boolean realizado, int prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.realizado = realizado;
        this.prioridade = prioridade;
    }

    public boolean isRealizado() {
        return realizado;
    }    

    @Override
    public boolean equals(Object obj) {
      return EqualsBuilder.reflectionEquals(obj, this);
    }
}

