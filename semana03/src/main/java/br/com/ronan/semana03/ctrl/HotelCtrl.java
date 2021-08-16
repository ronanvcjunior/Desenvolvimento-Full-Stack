package br.com.ronan.semana03.ctrl;

import java.util.ArrayList;
import java.util.List;

import br.com.ronan.semana03.business.HotelBusiness;
import br.com.ronan.semana03.entities.Hotel;
import br.com.ronan.semana03.exceptions.HotelException;

public class HotelCtrl {
    HotelBusiness business = new HotelBusiness();

    public List<Hotel> findAll() {
        List<Hotel> retorno = new ArrayList<Hotel>();

        try {
            retorno = business.findAll();
        } catch (HotelException e) {
            System.err.println(e.getMessage());
        }

        return retorno;
    }

    public Hotel findById(Integer id) {
        Hotel retorno = new Hotel();

        try {
            retorno = business.findById(id);
        } catch (HotelException e) {
            System.err.println(e.getMessage());
        }

        return retorno;
    }

    public Hotel insert(Hotel hotel) {
        try {
            hotel = business.insert(hotel);
        } catch (HotelException e) {
            System.err.println(e.getMessage());
        }

        return hotel;
    }

    public Hotel update(Hotel hotel) {
        try {
            hotel = business.update(hotel);
        } catch (HotelException e) {
            System.err.println(e.getMessage());
        }

        return hotel;
    }

    public void delete(Integer id) {
        try {
            business.delete(id);
        } catch (HotelException e) {
            System.err.println(e.getMessage());
        }
    }
}
