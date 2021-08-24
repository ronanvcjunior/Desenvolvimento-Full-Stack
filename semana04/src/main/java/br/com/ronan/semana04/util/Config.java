package br.com.ronan.semana04.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.ronan.semana04.domain.Hospedagem;
import br.com.ronan.semana04.domain.Hospede;
import br.com.ronan.semana04.domain.Hotel;
import br.com.ronan.semana04.domain.Quarto;
import br.com.ronan.semana04.enums.CategoriaQuarto;
import br.com.ronan.semana04.repository.HospedagemRepository;
import br.com.ronan.semana04.repository.HospedeRepository;
import br.com.ronan.semana04.repository.HotelRepository;
import br.com.ronan.semana04.repository.QuartoRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@Profile("dev")
public class Config implements CommandLineRunner{

    private final HotelRepository hotelRepository;
    private final QuartoRepository quartoRepository;
    private final HospedeRepository hospedeRepository;
    private final HospedagemRepository hospedagemRepository;

    private final DateUtil dateUtil;

    @Override
    public void run(String... args) throws Exception {
        Hotel h1 = new Hotel("Calderão Furado", "Beco Diagonal", 3);
        Hotel h2 = new Hotel("Bates Hotel", "White Pine Bay", 2);
        Hotel h3 = new Hotel("Hotel Overlook", "Colorado", 4);
        Hotel h4 = new Hotel("Continental Hotel", "Ney York City", 5);

        h1 = hotelRepository.save(h1);
        h2 = hotelRepository.save(h2);
        h3 = hotelRepository.save(h3);
        h4 = hotelRepository.save(h4);

        Quarto q1 = quartoRepository.save(new Quarto(h1, CategoriaQuarto.APARTAMENTO, 4, 1010, 200.0));
        Quarto q2 = quartoRepository.save(new Quarto(h2, CategoriaQuarto.SIMPLES, 1, 7, 100.0));
        Quarto q3 = quartoRepository.save(new Quarto(h3, CategoriaQuarto.PADRAO, 2, 306, 150.0));
        Quarto q4 = quartoRepository.save(new Quarto(h4, CategoriaQuarto.LUXO, 3, 1313, 500.0));

        Hospede hospede1 = hospedeRepository.save(new Hospede("Fernanda Helena da Cunha", dateUtil.formatDate("10/07/1996"), 157));
        Hospede hospede2 = hospedeRepository.save(new Hospede("Yuri Elias Benedito Drumond", dateUtil.formatDate("11/08/1959"), 657));
        Hospede hospede3 = hospedeRepository.save(new Hospede("Fernando Luan Benjamin Fogaça", dateUtil.formatDate("21/10/1962"), 301));
        Hospede hospede4 = hospedeRepository.save(new Hospede("Luciana Alícia Manuela Santos", dateUtil.formatDate("22/07/1952"), 312));

        hospedagemRepository.save(new Hospedagem(q1, hospede1, dateUtil.formatDate("24/08/2021"), dateUtil.formatDate("31/08/2021")));
        hospedagemRepository.save(new Hospedagem(q2, hospede2, dateUtil.formatDate("17/08/2021"), dateUtil.formatDate("12/09/2021")));
        hospedagemRepository.save(new Hospedagem(q3, hospede3, dateUtil.formatDate("27/08/2021"), dateUtil.formatDate("04/09/2021")));
        hospedagemRepository.save(new Hospedagem(q4, hospede4, dateUtil.formatDate("30/08/2021"), dateUtil.formatDate("30/10/2021")));
    }
    
}
