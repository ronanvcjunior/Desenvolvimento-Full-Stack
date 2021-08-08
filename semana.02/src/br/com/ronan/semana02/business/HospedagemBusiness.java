package br.com.ronan.semana02.business;

import java.util.List;

import br.com.ronan.semana02.dao.DB;
import br.com.ronan.semana02.dao.HospedagemDao;
import br.com.ronan.semana02.entities.Hospedagem;
import br.com.ronan.semana02.exceptions.HospedagemException;

public class HospedagemBusiness {
    HospedagemDao dao = new HospedagemDao(DB.getConnection());

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
