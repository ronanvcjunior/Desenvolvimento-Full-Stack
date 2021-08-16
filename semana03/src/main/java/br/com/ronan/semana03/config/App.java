package br.com.ronan.semana03.config;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.ronan.semana03.ctrl.HospedagemCtrl;
import br.com.ronan.semana03.ctrl.HospedeCtrl;
import br.com.ronan.semana03.ctrl.HotelCtrl;
import br.com.ronan.semana03.ctrl.QuartoCtrl;
import br.com.ronan.semana03.entities.Hospedagem;
import br.com.ronan.semana03.entities.Hospede;
import br.com.ronan.semana03.entities.Hotel;
import br.com.ronan.semana03.entities.Quarto;

public class App {
    public static void main( String[] args ) {
        testarHospedagemDao();
    }

    public static void testarHospedagemDao() {
        System.out.println("Inicio");

        HospedagemCtrl hospedagemCtrl = new HospedagemCtrl();

        testarHospedagemFindAll(hospedagemCtrl);

        // testarHospedagemFindById(hospedagemCtrl, 2);

        // Hospedagem h = new Hospedagem("Castle Host", "Inglaterra", 5);
        // testarHospedagemInserir(hospedagemCtrl, h);

        // Hospedagem h = hospedagemCtrl.findById(19);
        // h.setNmHospedagem("DigiHotel Master");
        // h.setEndereco("DigiWorld");
        // h.setQtdEstrelas(5);
        // testarHospedagemUpdate(hospedagemCtrl, h);

        // testarHospeagemeDelete(hospedagemCtrl, 15);

        System.out.println("Fim");
    }

    public static void testarHospedagemFindAll(HospedagemCtrl hospedagemCtrl) {
        List<Hospedagem> hospedagens = hospedagemCtrl.findAll();

        for (Hospedagem hospedagem : hospedagens) {
            System.out.println(hospedagem.toString());
        }
    }







    public static void testarHospedeDao() {
        System.out.println("Inicio");

        HospedeCtrl hospedeCtrl = new HospedeCtrl();

        testarHospedeFindAll(hospedeCtrl);

        // testarHospedeFindById(hospedeCtrl, 2);

        // Hospede h = new Hospede("Castle Host", "Inglaterra", 5);
        // testarHospedeInserir(hospedeCtrl, h);

        // Hospede h = hospedeCtrl.findById(19);
        // h.setNmHospede("DigiHotel Master");
        // h.setEndereco("DigiWorld");
        // h.setQtdEstrelas(5);
        // testarHospedeUpdate(hospedeCtrl, h);

        // testarHospedeDelete(hospedeCtrl, 15);

        System.out.println("Fim");
    }

    public static void testarHospedeFindAll(HospedeCtrl hospedeCtrl) {
        List<Hospede> hospedes = hospedeCtrl.findAll();

        for (Hospede hospede : hospedes) {
            System.out.println(hospede.toString());
        }
    }







    public static void testarQuartoDao() {
        System.out.println("Inicio");

        QuartoCtrl quartoCtrl = new QuartoCtrl();

        testarQuartoFindAll(quartoCtrl);

        // testarQuartoFindById(quartoCtrl, 2);

        // Quarto h = new Quarto("Castle Host", "Inglaterra", 5);
        // testarQuartoInserir(QuartoCtrl, h);

        // Quarto h = quartoCtrl.findById(19);
        // h.setNmQuarto("DigiHotel Master");
        // h.setEndereco("DigiWorld");
        // h.setQtdEstrelas(5);
        // testarQuartoUpdate(quartoCtrl, h);

        //testarQuartoDelete(quartoCtrl, 15);
        
        System.out.println("Fim");
    }

    public static void testarQuartoFindAll(QuartoCtrl quartoCtrl) {
        List<Quarto> quartos = quartoCtrl.findAll();

        for (Quarto quarto : quartos) {
        System.out.println(quarto.toString());
        }
    }




    

    // public static void testarHotelDao() {
    //     System.out.println("Inicio");

    //     HotelCtrl hotelCtrl = new HotelCtrl();

    //     // testarHotelFindAll(hotelCtrl);

    //     // testarHotelFindById(hotelCtrl, 2);

    //     // Hotel h = new Hotel("Castle Host", "Inglaterra", 5);
    //     // testarHotelInserir(hotelCtrl, h);

    //     // Hotel h = hotelCtrl.findById(19);
    //     // h.setNmHotel("DigiHotel Master");
    //     // h.setEndereco("DigiWorld");
    //     // h.setQtdEstrelas(5);
    //     // testarHotelUpdate(hotelCtrl, h);

    //     //testarHotelDelete(hotelCtrl, 15);
        
    //     System.out.println("Fim");
    // }

    // public static void testarHotelFindAll(HotelCtrl hotelCtrl) {
    //     List<Hotel> hoteis = hotelCtrl.findAll();

    //     for (Hotel hotel : hoteis) {
    //         System.out.println(hotel.toString());
    //     }
    // }

    // public static void testarHotelFindById(HotelCtrl hotelCtrl, Integer id) {
    //     Hotel hotel = hotelCtrl.findById(id);

    //     System.out.println(hotel.toString());
    // }

    // public static void testarHotelInserir(HotelCtrl hotelCtrl, Hotel h) {
    //     Hotel hotel = hotelCtrl.insert(h);

    //     System.out.println(hotel.toString());
    // }

    // public static void testarHotelUpdate(HotelCtrl hotelCtrl, Hotel h) {
    //     Hotel hotel = hotelCtrl.update(h);

    //     System.out.println(hotel.toString());
    // }

    // public static void testarHotelDelete(HotelCtrl hotelCtrl, Integer id) {
    //     hotelCtrl.delete(id);
    // }






    // public static void testarConexaoComBancoDeDados() {
    //     System.out.println("Inicio");

    //     EntityManager em = DaoFactory.getEm();

    //     //testarInserirHotel(em);
    //     //testarPesquisarAllHotel(em);
    //     //testarPesquisarPorIdHotel(em, 14);
    //     //testarPesquisarPorCampoNomeHotel(em, "as");
    //     //testarPesquisarPorCampoQtdEstrelasHotel(em, 2);
    //     //testarEditarHotel(em, 16);
    //     //testarDeletarHotel(em, 14);

    //     System.out.println("Fim");
    // }

    // public static void testarInserirHotel(EntityManager em) {
    //     Hotel hotel = new Hotel("Denali Hotel", "Anápolis", 4);

    //     em.getTransaction().begin();
    //     em.persist(hotel);
    //     em.getTransaction().commit();
    // }

    // public static void testarPesquisarAllHotel(EntityManager em) {
    //     TypedQuery<Hotel> result = em.createQuery("FROM Hotel", Hotel.class);

    //     List<Hotel> hoteis = result.getResultList();
        
    //     for (Hotel hotel : hoteis) {
    //         System.out.println(hotel.toString());
    //     }
    // }

    // public static void testarPesquisarPorIdHotel(EntityManager em, Integer id) {
    //     Hotel hotel = em.find(Hotel.class, id);

    //     System.out.println(hotel.toString());
    // }

    // public static void testarPesquisarPorCampoNomeHotel(EntityManager em, String str) {
    //     String sql = "FROM Hotel h WHERE h.nmHotel LIKE :str";
    //     TypedQuery<Hotel> result = em.createQuery(sql, Hotel.class);
    //     result.setParameter("str", "%"+str+"%");

    //     List<Hotel> hoteis = result.getResultList();

    //     for (Hotel hotel : hoteis) {
    //         System.out.println(hotel.toString());
    //     }
    // }

    // public static void testarPesquisarPorCampoQtdEstrelasHotel(EntityManager em, Integer str) {
    //     String sql = "FROM Hotel h WHERE h.qtdEstrelas LIKE :str";
    //     TypedQuery<Hotel> result = em.createQuery(sql, Hotel.class);
    //     result.setParameter("str", str);

    //     List<Hotel> hoteis = result.getResultList();

    //     for (Hotel hotel : hoteis) {
    //         System.out.println(hotel.toString());
    //     }
    // }

    // public static void testarEditarHotel(EntityManager em, Integer id) {
    //     Hotel hotel = em.find(Hotel.class, id);
    //     hotel.setNmHotel("Castor");

    //     em.getTransaction().begin();
    //     em.persist(hotel);
    //     em.getTransaction().commit();
    // }

    // public static void testarDeletarHotel(EntityManager em, Integer id) {
    //     Hotel hotel = em.find(Hotel.class, id);

    //     em.getTransaction().begin();
    //     em.remove(hotel);
    //     em.getTransaction().commit();
    // }
}
