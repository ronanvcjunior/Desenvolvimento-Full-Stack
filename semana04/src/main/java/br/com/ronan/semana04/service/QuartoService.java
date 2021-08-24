package br.com.ronan.semana04.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ronan.semana04.domain.Quarto;
import br.com.ronan.semana04.repository.QuartoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuartoService {
    
    private final QuartoRepository quartoRepository;

    public List<Quarto> findAll() {
        return quartoRepository.findAll();
    }

    public Quarto findById(Integer id) {
        Optional<Quarto> retorno = quartoRepository.findById(id);
        return retorno.get();
    }

    public Quarto insert(Quarto quarto) {
        return quartoRepository.save(quarto);
    }

    public Quarto update(Quarto quarto) {
        return quartoRepository.save(quarto);
    }

    public void delete(Integer id) {
        quartoRepository.deleteById(id);
    }
}
