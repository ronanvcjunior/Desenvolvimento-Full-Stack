package br.com.ronan.semana04.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ronan.semana04.domain.Quarto;
import br.com.ronan.semana04.service.QuartoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "quartos")
public class QuartoController {
    private final QuartoService quartoService;

    @GetMapping
    public ResponseEntity<List<Quarto>> findAll() {
        List<Quarto> list = quartoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Quarto> findById(@PathVariable Integer id) {
        Quarto retorno = quartoService.findById(id);
        return ResponseEntity.ok().body(retorno);
    }

    @PostMapping
    public ResponseEntity<Quarto> insert(@RequestBody Quarto quarto) {
        quarto = quartoService.insert(quarto);
        return ResponseEntity.ok(quarto);
    }

    @PutMapping
    public ResponseEntity<Quarto> update(@RequestBody Quarto quarto) {
        quarto = quartoService.update(quarto);
        return ResponseEntity.ok(quarto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        quartoService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
