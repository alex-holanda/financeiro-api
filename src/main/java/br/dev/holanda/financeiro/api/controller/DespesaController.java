package br.dev.holanda.financeiro.api.controller;

import br.dev.holanda.financeiro.domain.model.Despesa;
import br.dev.holanda.financeiro.domain.repository.DespesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "despesas")
public class DespesaController {

    private final DespesaRepository despesaRepository;

    @GetMapping("{criadoPor}")
    public ResponseEntity<List<Despesa>> list(@PathVariable String criadoPor) {
        return ResponseEntity.ok(despesaRepository.listarPorCriadoPor(criadoPor));
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody Object despesa) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
