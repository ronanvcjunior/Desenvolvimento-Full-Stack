package br.com.ronan.semana04.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ronan.semana04.domain.Hotel;
import br.com.ronan.semana04.repository.HotelRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    public Hotel findById(Integer id) {
        Optional<Hotel> retorno = hotelRepository.findById(id);
        return retorno.get();
    }

    public Hotel insert(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel update(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void delete(Integer id) {
        hotelRepository.deleteById(id);
    }
}
