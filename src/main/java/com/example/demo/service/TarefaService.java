package com.example.demo.service;

import com.example.demo.dto.TarefaReqDTO;
import com.example.demo.dto.TarefaResDTO;

import java.util.List;

public interface TarefaService {

    TarefaResDTO create(TarefaReqDTO dto);
    TarefaResDTO getById(Long id);
    List<TarefaResDTO> getAll();
    TarefaResDTO update(Long id, TarefaReqDTO dto);
    void delete(Long id);
}
