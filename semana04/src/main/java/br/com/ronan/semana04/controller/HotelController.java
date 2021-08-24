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

import br.com.ronan.semana04.domain.Hotel;
import br.com.ronan.semana04.service.HotelService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "hoteis")
@RequiredArgsConstructor
public class HotelController {
    
    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Hotel>> findAll() {
        List<Hotel> list = hotelService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Hotel> findById(@PathVariable Integer id) {
        Hotel retorno = hotelService.findById(id);
        return ResponseEntity.ok().body(retorno);
    }

    @PostMapping
    public ResponseEntity<Hotel> insert(@RequestBody Hotel hotel) {
        hotel = hotelService.insert(hotel);
        return ResponseEntity.ok(hotel);
    }

    @PutMapping
    public ResponseEntity<Hotel> update(@RequestBody Hotel hotel) {
        hotel = hotelService.update(hotel);
        return ResponseEntity.ok(hotel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        hotelService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
