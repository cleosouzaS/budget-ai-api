package com.cleosouza.budget_ai_api.controller;

import com.cleosouza.budget_ai_api.entity.Transacao;
import com.cleosouza.budget_ai_api.repository.TransacaoRepository;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoRepository repository;

    public TransacaoController(TransacaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Transacao> listar() {
        return repository.findAll();   }

    @PostMapping
    public Transacao criar(@Valid @RequestBody Transacao transacao) {
        return repository.save(transacao);
    }
      @GetMapping("/{id}")
    public Transacao buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
@PutMapping("/{id}")
public Transacao atualizar(@PathVariable Long id,@Valid  @RequestBody Transacao transacao) {
    return repository.findById(id)
            .map(existente -> {
                existente.setDescricao(transacao.getDescricao());
                existente.setValor(transacao.getValor());
                existente.setTipo(transacao.getTipo());
                return repository.save(existente);
            })
            .orElse(null);
   }
@DeleteMapping("/{id}")
public void deletar(@PathVariable Long id) {
    repository.deleteById(id);
   }
}

 
