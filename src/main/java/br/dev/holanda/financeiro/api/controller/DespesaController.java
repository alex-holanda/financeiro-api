package br.dev.holanda.financeiro.api.controller;

import br.dev.holanda.financeiro.domain.repository.DespesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "despesas")
public class DespesaController {

    private final DespesaRepository despesaRepository;

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody Object despesa) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
