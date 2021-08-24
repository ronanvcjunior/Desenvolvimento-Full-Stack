package br.com.ronan.semana04.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ronan.semana04.domain.Hospedagem;
import br.com.ronan.semana04.repository.HospedagemRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HospedagemService {
    private final HospedagemRepository hospedagemRepository;

    public List<Hospedagem> findAll() {
        return hospedagemRepository.findAll();
    }

    public Hospedagem findById(Integer id) {
        Optional<Hospedagem> retorno = hospedagemRepository.findById(id);
        return retorno.get();
    }

    public Hospedagem insert(Hospedagem hospedagem) {
        return hospedagemRepository.save(hospedagem);
    }

    public Hospedagem update(Hospedagem hospedagem) {
        return hospedagemRepository.save(hospedagem);
    }

    public void delete(Integer id) {
        hospedagemRepository.deleteById(id);
    }
}
