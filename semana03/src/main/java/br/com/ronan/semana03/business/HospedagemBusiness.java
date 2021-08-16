package br.com.ronan.semana03.business;

import java.util.List;

import br.com.ronan.semana03.config.DaoFactory;
import br.com.ronan.semana03.dao.HospedagemDao;
import br.com.ronan.semana03.entities.Hospedagem;
import br.com.ronan.semana03.exceptions.HospedagemException;

public class HospedagemBusiness {
    HospedagemDao dao = new HospedagemDao(DaoFactory.getEm());

    public List<Hospedagem> findAll() throws HospedagemException {
        return dao.findAll();
    }

    public Hospedagem findById(Integer id) throws HospedagemException {
        return dao.findById(id);
    }

    public Hospedagem insert(Hospedagem hospedagem) throws HospedagemException {
        return dao.insert(hospedagem);
    }

    public Hospedagem update(Hospedagem hospedagem) throws HospedagemException {
        return dao.update(hospedagem);
    }

    public void delete(Integer id) throws HospedagemException {
        dao.delete(id);
    }
}
