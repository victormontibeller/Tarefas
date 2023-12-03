package com.Tarefas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    ResponseEntity<List<Tarefa>> create (@Validated @RequestBody Tarefa tarefa){
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.create(tarefa));
    }

    @GetMapping 
    List<Tarefa> list (){
        return tarefaService.list();
    }
    
    @PutMapping
    List<Tarefa> update (@PathVariable Long id, @RequestBody Tarefa tarefa){
        return tarefaService.update(id, tarefa);
    }
    
    @DeleteMapping("{id}")
    List<Tarefa> delete (@PathVariable Long id){
        return tarefaService.delete(id);
    }    
}
