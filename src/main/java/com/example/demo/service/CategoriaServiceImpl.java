package com.example.demo.service;

import com.example.demo.dto.CategoriaReqDTO;
import com.example.demo.dto.CategoriaResDTO;
import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoriaResDTO create(CategoriaReqDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.nome());

        return CategoriaResDTO.valueOf(repository.save(categoria));
    }

    @Override
    public CategoriaResDTO getById(Long id) {
        Categoria categoria = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return CategoriaResDTO.valueOf(categoria);
    }

    @Override
    public List<CategoriaResDTO> getAll() {
        return repository.findAll().stream()
                .map(CategoriaResDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaResDTO update(Long id, CategoriaReqDTO dto) {
        Categoria categoria = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        categoria.setNome(dto.nome());

        return CategoriaResDTO.valueOf(repository.save(categoria));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada");
        }
        repository.deleteById(id);
    }
}
