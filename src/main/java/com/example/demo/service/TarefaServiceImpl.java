package com.example.demo.service;

import com.example.demo.dto.TarefaReqDTO;
import com.example.demo.dto.TarefaResDTO;
import com.example.demo.model.Categoria;
import com.example.demo.model.Tarefa;
import com.example.demo.model.Usuario;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.TarefaRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public TarefaServiceImpl(
            TarefaRepository tarefaRepository,
            UsuarioRepository usuarioRepository,
            CategoriaRepository categoriaRepository
    ) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public TarefaResDTO create(TarefaReqDTO dto) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.titulo());
        tarefa.setDescricao(dto.descricao());
        tarefa.setDataCriacao(dto.dataCriacao());
        tarefa.setDataConclusao(dto.dataConclusao());
        tarefa.setStatus(dto.status());
        tarefa.setPrioridade(dto.prioridade());

        Usuario responsavel = usuarioRepository.findById(dto.responsavelId())
                .orElseThrow(() -> new RuntimeException("Responsável não encontrado"));
        tarefa.setResponsavel(responsavel);

        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        tarefa.setCategoria(categoria);

        return TarefaResDTO.valueOf(tarefaRepository.save(tarefa));
    }

    @Override
    public TarefaResDTO getById(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        return TarefaResDTO.valueOf(tarefa);
    }

    @Override
    public List<TarefaResDTO> getAll() {
        return tarefaRepository.findAll().stream()
                .map(TarefaResDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public TarefaResDTO update(Long id, TarefaReqDTO dto) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefa.setTitulo(dto.titulo());
        tarefa.setDescricao(dto.descricao());
        tarefa.setDataCriacao(dto.dataCriacao());
        tarefa.setDataConclusao(dto.dataConclusao());
        tarefa.setStatus(dto.status());
        tarefa.setPrioridade(dto.prioridade());

        Usuario responsavel = usuarioRepository.findById(dto.responsavelId())
                .orElseThrow(() -> new RuntimeException("Responsável não encontrado"));
        tarefa.setResponsavel(responsavel);

        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        tarefa.setCategoria(categoria);

        return TarefaResDTO.valueOf(tarefaRepository.save(tarefa));
    }

    @Override
    public void delete(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada");
        }
        tarefaRepository.deleteById(id);
    }
}
