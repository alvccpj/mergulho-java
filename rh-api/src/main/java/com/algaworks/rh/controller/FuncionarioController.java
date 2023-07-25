package com.algaworks.rh.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.algaworks.rh.model.Funcionario;
import com.algaworks.rh.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
   
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping
    public List<Funcionario> listar () {
        return funcionarioRepository.findAll();
    }

    @GetMapping("/{funcionarioId}")
    public ResponseEntity<Funcionario> buscar (@PathVariable Long funcionarioId) {
        return funcionarioRepository.findById(funcionarioId)
            .map(funcionario -> ResponseEntity.ok(funcionario))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario cadastrar (@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @PutMapping("/{funcionarioId}")
    public ResponseEntity<Funcionario> atualizar (@PathVariable Long funcionarioId, @RequestBody Funcionario funcionario) {
        if (!funcionarioRepository.existsById(funcionarioId)) {
            return ResponseEntity.notFound().build();
        }
        
        funcionario.setId(funcionarioId);
        Funcionario funcionarioAtualizado = funcionarioRepository.save(funcionario);
        return ResponseEntity.ok(funcionarioAtualizado);
    }

}
