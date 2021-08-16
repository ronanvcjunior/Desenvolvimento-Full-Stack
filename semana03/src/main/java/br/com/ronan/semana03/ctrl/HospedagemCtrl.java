package br.com.ronan.semana03.ctrl;

import java.util.ArrayList;
import java.util.List;

import br.com.ronan.semana03.business.HospedagemBusiness;
import br.com.ronan.semana03.entities.Hospedagem;
import br.com.ronan.semana03.exceptions.HospedagemException;

public class HospedagemCtrl {
    HospedagemBusiness business = new HospedagemBusiness();

    public List<Hospedagem> findAll() {
        List<Hospedagem> retorno = new ArrayList<Hospedagem>();
        try {
            retorno = business.findAll();
        } catch (HospedagemException e) {
            System.err.println(e.getMessage());
        }

        return retorno;
    }

    public Hospedagem findById(Integer id) {
        Hospedagem retorno = new Hospedagem();
        try {
            retorno = business.findById(id);
        } catch (HospedagemException e) {
            System.err.println(e.getMessage());
        }

        return retorno;
    }

    public Hospedagem insert(Hospedagem hospedagem) {
        try {
            hospedagem = business.insert(hospedagem);
        } catch (HospedagemException e) {
            System.err.println(e.getMessage());
        }

        return hospedagem;
    }

    public Hospedagem update(Hospedagem hospedagem) {
        try {
            hospedagem = business.update(hospedagem);
        } catch (HospedagemException e) {
            System.err.println(e.getMessage());
        }

        return hospedagem;
    }

    public void delete(Integer id) {
        try {
            business.delete(id);
        } catch (HospedagemException e) {
            System.err.println(e.getMessage());
        }
    }
}
