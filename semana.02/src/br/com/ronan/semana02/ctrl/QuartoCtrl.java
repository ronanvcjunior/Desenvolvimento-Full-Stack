package br.com.ronan.semana02.ctrl;

import java.util.ArrayList;
import java.util.List;

import br.com.ronan.semana02.business.QuartoBusiness;
import br.com.ronan.semana02.entities.Quarto;
import br.com.ronan.semana02.exceptions.QuartoException;

public class QuartoCtrl {
    QuartoBusiness business = new QuartoBusiness();

    public List<Quarto> findAll() {
        List<Quarto> retorno = new ArrayList<Quarto>();
        try {
            retorno = business.findAll();
        } catch (QuartoException e) {
            System.err.println(e.getMessage());
        }

        return retorno;
    }

    public Quarto findById(Integer id) {
        Quarto retorno = new Quarto();
        try {
            retorno = business.findById(id);
        } catch (QuartoException e) {
            System.err.println(e.getMessage());
        }

        return retorno;
    }

    public Quarto insert(Quarto quarto) {
        Quarto retorno = new Quarto();
        try {
            retorno = business.insert(quarto);
        } catch (QuartoException e) {
            System.err.println(e.getMessage());
        }

        return retorno;
    }

    public Quarto update(Quarto quarto) {
        Quarto retorno = new Quarto();
        try {
            retorno = business.update(quarto);
        } catch (QuartoException e) {
            System.err.println(e.getMessage());
        }

        return retorno;
    }

    public void delete(Integer id) {
        try {
            business.delete(id);
        } catch (QuartoException e) {
            System.err.println(e.getMessage());
        }
    }
}
