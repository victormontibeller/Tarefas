package com.Tarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tarefas.entity.Tarefa;
import com.Tarefas.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    
    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    private List<Tarefa> create (@RequestBody Tarefa tarefa){
        return tarefaService.create(tarefa);
    }

    @GetMapping 
    private List<Tarefa> list (){
        return tarefaService.list();
    }
    
    @PutMapping
    private List<Tarefa> update (@RequestBody Tarefa tarefa){
        return this.tarefaService.update(tarefa);
    }
    
    @DeleteMapping("{id}")
    private List<Tarefa> delete (@PathVariable("id") Long id){
        return tarefaService.delete(id);
    }    
}
