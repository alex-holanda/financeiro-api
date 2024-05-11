package br.dev.holanda.financeiro.api.controller;

import br.dev.holanda.financeiro.domain.model.Contabilidade;
import br.dev.holanda.financeiro.domain.repository.ContabilidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "contabilidade")
public class ContabilidadeController {

    private final ContabilidadeRepository contabilidadeRepository;

    @GetMapping
    public ResponseEntity<List<Contabilidade>> balanco(Authentication connectedUser) {
        return ResponseEntity.ok(contabilidadeRepository.buscarPorCriadoPor(connectedUser.getName()));
    }
}
