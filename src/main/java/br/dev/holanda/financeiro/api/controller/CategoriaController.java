package br.dev.holanda.financeiro.api.controller;

import br.dev.holanda.financeiro.domain.model.Categoria;
import br.dev.holanda.financeiro.domain.repository.CategoriaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Categoria>> list() {
        return ResponseEntity.ok(categoriaRepository.listar());
    }

    @GetMapping("{categoriaId}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long categoriaId) {
        return ResponseEntity.ok(categoriaRepository.buscarPorId(categoriaId));
    }

    @PostMapping
    public ResponseEntity<Long> cadastrar(@RequestBody @Valid Categoria categoria) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoriaRepository.cadastrar(categoria));
    }

    @PutMapping("{categoriaId}")
    public ResponseEntity<Long> atualizar(@PathVariable Long categoriaId, @RequestBody @Valid Categoria categoria) {
        return ResponseEntity.ok(categoriaRepository.atualizar(categoriaId, categoria));
    }
}
