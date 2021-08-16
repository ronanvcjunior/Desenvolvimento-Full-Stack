package br.com.ronan.semana03.config;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.ronan.semana03.entities.Hotel;

public class App {
    public static void main( String[] args ) {
        testarConexaoComBancoDeDados();
    }

    public static void testarConexaoComBancoDeDados() {
        System.out.println("Inicio");

        EntityManager em = DaoFactory.getEm();

        //testarInserirHotel(em);
        //testarPesquisarAllHotel(em);
        //testarPesquisarPorIdHotel(em, 14);
        //testarPesquisarPorCampoNomeHotel(em, "as");
        //testarPesquisarPorCampoQtdEstrelasHotel(em, 2);
        //testarEditarHotel(em, 16);
        testarDeletarHotel(em, 14);

        System.out.println("Fim");
    }

    public static void testarInserirHotel(EntityManager em) {
        Hotel hotel = new Hotel("Denali Hotel", "Anápolis", 4);

        em.getTransaction().begin();
        em.persist(hotel);
        em.getTransaction().commit();
    }

    public static void testarPesquisarAllHotel(EntityManager em) {
        TypedQuery<Hotel> result = em.createQuery("FROM Hotel", Hotel.class);

        List<Hotel> hoteis = result.getResultList();
        
        for (Hotel hotel : hoteis) {
            System.out.println(hotel.toString());
        }
    }

    public static void testarPesquisarPorIdHotel(EntityManager em, Integer id) {
        Hotel hotel = em.find(Hotel.class, id);

        System.out.println(hotel.toString());
    }

    public static void testarPesquisarPorCampoNomeHotel(EntityManager em, String str) {
        String sql = "FROM Hotel h WHERE h.nmHotel LIKE :str";
        TypedQuery<Hotel> result = em.createQuery(sql, Hotel.class);
        result.setParameter("str", "%"+str+"%");

        List<Hotel> hoteis = result.getResultList();

        for (Hotel hotel : hoteis) {
            System.out.println(hotel.toString());
        }
    }

    public static void testarPesquisarPorCampoQtdEstrelasHotel(EntityManager em, Integer str) {
        String sql = "FROM Hotel h WHERE h.qtdEstrelas LIKE :str";
        TypedQuery<Hotel> result = em.createQuery(sql, Hotel.class);
        result.setParameter("str", str);

        List<Hotel> hoteis = result.getResultList();

        for (Hotel hotel : hoteis) {
            System.out.println(hotel.toString());
        }
    }

    public static void testarEditarHotel(EntityManager em, Integer id) {
        Hotel hotel = em.find(Hotel.class, id);
        hotel.setNmHotel("Castor");

        em.getTransaction().begin();
        em.persist(hotel);
        em.getTransaction().commit();
    }

    public static void testarDeletarHotel(EntityManager em, Integer id) {
        Hotel hotel = em.find(Hotel.class, id);
        hotel.setNmHotel("Castor");

        em.getTransaction().begin();
        em.remove(hotel);
        em.getTransaction().commit();
    }
}
