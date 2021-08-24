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

import br.com.ronan.semana04.domain.Hospedagem;
import br.com.ronan.semana04.service.HospedagemService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "hospedagens")
public class HospedagemController {
    private final HospedagemService hospedagemService;

    @GetMapping
    public ResponseEntity<List<Hospedagem>> findAll() {
        List<Hospedagem> list = hospedagemService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Hospedagem> findById(@PathVariable Integer id) {
        Hospedagem retorno = hospedagemService.findById(id);
        return ResponseEntity.ok().body(retorno);
    }

    @PostMapping
    public ResponseEntity<Hospedagem> insert(@RequestBody Hospedagem hospedagem) {
        hospedagem = hospedagemService.insert(hospedagem);
        return ResponseEntity.ok(hospedagem);
    }

    @PutMapping
    public ResponseEntity<Hospedagem> update(@RequestBody Hospedagem hospedagem) {
        hospedagem = hospedagemService.update(hospedagem);
        return ResponseEntity.ok(hospedagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        hospedagemService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
