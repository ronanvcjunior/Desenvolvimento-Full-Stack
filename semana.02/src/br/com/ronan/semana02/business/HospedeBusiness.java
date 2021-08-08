package br.com.ronan.semana02.business;

import java.util.List;

import br.com.ronan.semana02.dao.DB;
import br.com.ronan.semana02.dao.HospedeDao;
import br.com.ronan.semana02.entities.Hospede;
import br.com.ronan.semana02.exceptions.HospedeException;

public class HospedeBusiness {
    HospedeDao dao = new HospedeDao(DB.getConnection());

    public List<Hospede> findAll() throws HospedeException {
        return dao.findAll();
    }

    public Hospede findById(Integer id) throws HospedeException {
        return dao.findById(id);
    }

    public Hospede insert(Hospede hospede) throws HospedeException {
        return dao.insert(hospede);
    }

    public Hospede update(Hospede hospede) throws HospedeException {
        return dao.update(hospede);
    }

    public void delete(Integer id) throws HospedeException {
        dao.delete(id);
    }
}
