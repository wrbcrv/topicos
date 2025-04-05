package com.example.demo.service;

import com.example.demo.dto.CategoriaReqDTO;
import com.example.demo.dto.CategoriaResDTO;

import java.util.List;

public interface CategoriaService {

    CategoriaResDTO create(CategoriaReqDTO dto);
    CategoriaResDTO getById(Long id);
    List<CategoriaResDTO> getAll();
    CategoriaResDTO update(Long id, CategoriaReqDTO dto);
    void delete(Long id);
}
