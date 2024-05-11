package br.dev.holanda.financeiro.api.controller;

import br.dev.holanda.financeiro.domain.repository.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "receitas")
public class ReceitaController {

    private final ReceitaRepository receitaRepository;

}
