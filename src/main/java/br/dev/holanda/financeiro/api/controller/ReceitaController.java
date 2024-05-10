package br.dev.holanda.financeiro.api.controller;

import br.dev.holanda.financeiro.domain.model.Receita;
import br.dev.holanda.financeiro.domain.repository.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "receitas")
public class ReceitaController {

    private final ReceitaRepository receitaRepository;

    @GetMapping("{criadoPor}")
    public ResponseEntity<List<Receita>> list(@PathVariable String criadoPor) {
        return ResponseEntity.ok(receitaRepository.listarPorCriadoPor(criadoPor));
    }
}
