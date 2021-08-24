package br.com.ronan.semana04.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ronan.semana04.domain.Hospede;
import br.com.ronan.semana04.repository.HospedeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HospedeService {
    private final HospedeRepository hospedeRepository;

    public List<Hospede> findAll() {
        return hospedeRepository.findAll();
    }

    public Hospede findById(Integer id) {
        Optional<Hospede> retorno = hospedeRepository.findById(id);
        return retorno.get();
    }

    public Hospede insert(Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    public Hospede update(Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    public void delete(Integer id) {
        hospedeRepository.deleteById(id);
    }
}
