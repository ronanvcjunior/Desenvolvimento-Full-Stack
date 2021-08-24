package br.com.ronan.semana04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ronan.semana04.domain.Quarto;

public interface QuartoRepository extends JpaRepository<Quarto, Integer> {
    
}
