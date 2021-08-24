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

import br.com.ronan.semana04.domain.Hospede;
import br.com.ronan.semana04.service.HospedeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "hospedes")
public class HospedeController {
    private final HospedeService hospedeService;

    @GetMapping
    public ResponseEntity<List<Hospede>> findAll() {
        List<Hospede> list = hospedeService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Hospede> findById(@PathVariable Integer id) {
        Hospede retorno = hospedeService.findById(id);
        return ResponseEntity.ok().body(retorno);
    }

    @PostMapping
    public ResponseEntity<Hospede> insert(@RequestBody Hospede hospede) {
        hospede = hospedeService.insert(hospede);
        return ResponseEntity.ok(hospede);
    }

    @PutMapping
    public ResponseEntity<Hospede> update(@RequestBody Hospede hospede) {
        hospede = hospedeService.update(hospede);
        return ResponseEntity.ok(hospede);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        hospedeService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
