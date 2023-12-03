package com.Tarefas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.Tarefas.entity.Tarefa;
import com.Tarefas.repository.TarefaRepository;

@Service
public class TarefaService {
    
    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> create(Tarefa tarefa){
        tarefaRepository.save(tarefa);
        return this.list();
    }

    public List<Tarefa> list(){
        Sort sort = Sort.by(Direction.DESC, "prioridade").and(Sort.by(Direction.ASC,"id"));
        return tarefaRepository.findAll(sort);
    }
    
    public List<Tarefa> update(Tarefa tarefa){
        tarefaRepository.save(tarefa);
        return this.list();
    }
    
    public List<Tarefa> delete(Long id){
        tarefaRepository.deleteById(id);
        return this.list();
    }    
}
