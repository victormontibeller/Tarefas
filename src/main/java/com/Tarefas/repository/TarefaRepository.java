package com.Tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Tarefas.entity.Tarefa;

public interface TarefaRepository extends JpaRepository <Tarefa, Long>{
        
}
