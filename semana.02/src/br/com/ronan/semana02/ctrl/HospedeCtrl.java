package br.com.ronan.semana02.ctrl;

import java.util.ArrayList;
import java.util.List;

import br.com.ronan.semana02.business.HospedeBusiness;
import br.com.ronan.semana02.entities.Hospede;
import br.com.ronan.semana02.exceptions.HospedeException;

public class HospedeCtrl {
    
    HospedeBusiness business = new HospedeBusiness();

    public List<Hospede> findAll() {
        List<Hospede> retorno = new ArrayList<Hospede>();

        try {
            retorno = business.findAll();
        } catch (HospedeException e) {
            System.err.println(e.getMessage());
        }

        return retorno;
    }

    public Hospede findById(Integer id) {
        Hospede retorno = new Hospede();
        try {
            retorno = business.findById(id);
        } catch (HospedeException e) {
            System.err.println(e.getMessage());
        }

        return retorno;
    }

    public Hospede insert(Hospede hospede) {
        try {
            hospede = business.insert(hospede);
        } catch (HospedeException e) {
            System.err.println(e.getMessage());
        }

        return hospede;
    }

    public Hospede update(Hospede hospede) {
        try {
            hospede = business.update(hospede);
        } catch (HospedeException e) {
            System.err.println(e.getMessage());
        }

        return hospede;
    }

    public void delete(Integer id) {
        try {
            business.delete(id);
        } catch (HospedeException e) {
            System.err.println(e.getMessage());
        }

    }
}
