package util;

import java.sql.*;

import br.com.ronan.semana02.business.PostsSystems;
import br.com.ronan.semana02.ctrl.HotelCtrl;
import br.com.ronan.semana02.ctrl.QuartoCtrl;
import br.com.ronan.semana02.dao.DB;
import br.com.ronan.semana02.entities.Hotel;
import br.com.ronan.semana02.entities.Quarto;
import br.com.ronan.semana02.enums.CategoriaQuarto;

public class App {
    
    public static void main(String[] args) {
        testeCrudQuarto();
    }

    public static void testeSystem() {

        System.out.println("Hello World");
        System.err.println("Hello World com erro");

    }

    public static void testePostSystem() {
        System.out.println(PostsSystems.getPost("password"));
    }

    public static void testeConexao() {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String url = PostsSystems.getPost("dburl");
            String password = PostsSystems.getPost("password");
            String user = PostsSystems.getPost("user");
            Connection con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT id_hotel, nm_hotel FROM db_hotel.tb_hotel");
            System.out.println(PostsSystems.getPost("ok01"));
            while (rs.next()) {
                System.out.println(rs.getInt("id_hotel") + " " + rs.getString("nm_hotel"));
            }
        } catch (SQLException e) {
            System.err.println(PostsSystems.getPost("erro01"));
            System.out.println(e.getMessage());
        } finally {
            DB.closeStatment(stmt);
            DB.closeResultSet(rs);
        }
    }

    public static void testeCrudHotel() {
        
        HotelCtrl ctrl = new HotelCtrl();

        System.out.println(PostsSystems.getPost("hoteis"));
        for (Hotel h : ctrl.findAll()) {
            System.out.println(h);
        }

        System.out.println();
        System.out.println("=========================================================");
        System.out.println("=========================================================");
        System.out.println();

        Integer id = 2;
        System.out.println(PostsSystems.getPost("hotel_id") + id);
        Hotel hotel = ctrl.findById(id);
        System.out.println(hotel);

        System.out.println();
        System.out.println("=========================================================");
        System.out.println("=========================================================");
        System.out.println();

        System.out.println(PostsSystems.getPost("inserir_hotel"));
        Hotel h1 = new Hotel("Hotelzão", "Goiânia", 5);
        //h1 = ctrl.insert(h1);
        System.out.println(h1);

        System.out.println();
        System.out.println("=========================================================");
        System.out.println("=========================================================");
        System.out.println();

        Hotel h2 = ctrl.findById(id);
        System.out.println(PostsSystems.getPost("update_hotel") + id);
        System.out.println(h2);
        h2.setNmHotel(h2.getNmHotel() + " ALTERADO");
        h2.setQtdEstrelas(1);
        //h2 = ctrl.update(h2);
        System.out.println("#ID alterado: " + h2);

        System.out.println();
        System.out.println("=========================================================");
        System.out.println("=========================================================");
        System.out.println();

        System.out.println(PostsSystems.getPost("hoteis"));
        for (Hotel h : ctrl.findAll()) {
            System.out.println(h);
        }

        Integer idDel = 6;
        System.out.println(PostsSystems.getPost("delete_hotel") + idDel);
        //ctrl.delete(idDel);

        System.out.println(PostsSystems.getPost("hoteis") + "ATUALIZADO");
        for (Hotel h : ctrl.findAll()) {
            System.out.println(h);
        }

        System.out.println();
        System.out.println("=========================================================");
        System.out.println("=========================================================");
        System.out.println();

        h1 = ctrl.insert(h1);
        System.out.println(h1);
    }

    public static void testeCrudQuarto() {

        HotelCtrl hotelCtrl = new HotelCtrl();
        QuartoCtrl ctrl = new QuartoCtrl();

        System.out.println(PostsSystems.getPost("quartos"));
        for (Quarto q : ctrl.findAll()) {
            System.out.println(q);
        }

        System.out.println();
        System.out.println("=========================================================");
        System.out.println("=========================================================");
        System.out.println();

        Integer id = 1;
        System.out.println(PostsSystems.getPost("quarto_id") + id);
        Quarto quarto = ctrl.findById(id);
        System.out.println(quarto);

        System.out.println();
        System.out.println("=========================================================");
        System.out.println("=========================================================");
        System.out.println();

        System.out.println(PostsSystems.getPost("inserir_quarto"));
        Quarto q1 = new Quarto(hotelCtrl.findById(1), CategoriaQuarto.APARTAMENTO, 3, 120, 240.0);
        //q1 = ctrl.insert(q1);
        System.out.println(q1);

        System.out.println();
        System.out.println("=========================================================");
        System.out.println("=========================================================");
        System.out.println();

        Quarto q2 = ctrl.findById(id);
        System.out.println(PostsSystems.getPost("update_quarto") + id);
        System.out.println(q2);
        q2.setPrDiaria(q2.getPrDiaria() + 20);
        q2 = ctrl.update(q2);
        q2 = ctrl.update(q2);
        System.out.println("#ID alterado: " + q2);

        System.out.println();
        System.out.println("=========================================================");
        System.out.println("=========================================================");
        System.out.println();

        System.out.println(PostsSystems.getPost("quartos"));
        for (Quarto q : ctrl.findAll()) {
            System.out.println(q);
        }

        Integer idDel = 5;
        System.out.println(PostsSystems.getPost("delete_hotel") + idDel);
        ctrl.delete(idDel);
        System.out.println(PostsSystems.getPost("quartos") + "ATUALIZADO");
        for (Quarto q : ctrl.findAll()) {
            System.out.println(q);
        }
    }
}