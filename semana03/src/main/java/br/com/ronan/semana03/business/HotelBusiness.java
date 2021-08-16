package br.com.ronan.semana03.business;

import java.util.List;

import br.com.ronan.semana03.config.DaoFactory;
import br.com.ronan.semana03.dao.HotelDao;
import br.com.ronan.semana03.entities.Hotel;
import br.com.ronan.semana03.exceptions.HotelException;

public class HotelBusiness {

    HotelDao dao = new HotelDao(DaoFactory.getEm());

    public List<Hotel> findAll() throws HotelException {
        return dao.findAll();
    }

    public Hotel findById(Integer id) throws HotelException {
        return dao.findById(id);
    }

    public Hotel insert(Hotel hotel) throws HotelException {
        return dao.insert(hotel);
    }

    public Hotel update(Hotel hotel) throws HotelException {
        return dao.update(hotel);
    }

    public void delete(Integer id) throws HotelException {
        dao.delete(id);
    }
}
