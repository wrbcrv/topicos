package com.example.demo.controller;

import com.example.demo.dto.TarefaReqDTO;
import com.example.demo.dto.TarefaResDTO;
import com.example.demo.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<?> createTarefa(@RequestBody TarefaReqDTO dto) {
        try {
            TarefaResDTO novaTarefa = tarefaService.create(dto);
            return ResponseEntity.ok(novaTarefa);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTarefaById(@PathVariable Long id) {
        try {
            TarefaResDTO tarefa = tarefaService.getById(id);
            return ResponseEntity.ok(tarefa);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllTarefas() {
        try {
            List<TarefaResDTO> tarefas = tarefaService.getAll();
            return ResponseEntity.ok(tarefas);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTarefa(@PathVariable Long id, @RequestBody TarefaReqDTO dto) {
        try {
            TarefaResDTO tarefaAtualizada = tarefaService.update(id, dto);
            return ResponseEntity.ok(tarefaAtualizada);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTarefa(@PathVariable Long id) {
        try {
            tarefaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
