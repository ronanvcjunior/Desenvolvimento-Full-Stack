package br.com.ronan.semana02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.ronan.semana02.business.PostsSystems;
import br.com.ronan.semana02.entities.Hotel;
import br.com.ronan.semana02.exceptions.HotelException;

public class HotelDao {
    Connection conn;

    public HotelDao(Connection conn) {
        this.conn = conn;
    }

    public List<Hotel> findAll() throws HotelException {
        
        List<Hotel> retorno = new ArrayList<Hotel>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT id_hotel, nm_hotel, endereco, qtd_estrelas FROM db_hotel.tb_hotel";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Hotel hotel = new Hotel(
                        rs.getInt("id_hotel"), 
                        rs.getString("nm_hotel"), 
                        rs.getString("endereco"),
                        rs.getInt("qtd_estrelas"));

                retorno.add(hotel);
            }
        } catch (SQLException e) {
            throw new HotelException(PostsSystems.getPost("erro02") + e.getMessage());
        } finally {
            DB.closeStatment(st);
            DB.closeResultSet(rs);
        }

        return retorno;
    }

    public Hotel findById(Integer id) throws HotelException {

        Hotel retorno = new Hotel();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT id_hotel, nm_hotel, endereco, qtd_estrelas FROM db_hotel.tb_hotel WHERE id_hotel = " + id;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                retorno = new Hotel(
                        rs.getInt("id_hotel"), 
                        rs.getString("nm_hotel"), 
                        rs.getString("endereco"),
                        rs.getInt("qtd_estrelas"));
            }
        } catch (SQLException e) {
            throw new HotelException(PostsSystems.getPost("erro02") + e.getMessage());
        } finally {
            DB.closeStatment(st);
            DB.closeResultSet(rs);
        }

        return retorno;
    }

    public Hotel insert(Hotel hotel) throws HotelException {

        PreparedStatement st = null;
        try {
            String sql = "INSERT INTO tb_hotel (nm_hotel, endereco, qtd_estrelas) VALUES (?, ?, ?)";
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, hotel.getNmHotel());
            st.setString(2, hotel.getEndereco());
            st.setInt(3, hotel.getQtdEstrelas());
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    hotel.setIdHotel(rs.getInt(1));
                }
            }else {
                throw new HotelException(PostsSystems.getPost("erro03"));
            }
        } catch (SQLException e) {
            throw new HotelException(PostsSystems.getPost("erro02") + e.getMessage());
        } finally {
            DB.closeStatment(st);
        }

        return hotel;
    }

    public Hotel update(Hotel hotel) throws HotelException {

        PreparedStatement st = null;
        try {
            String sql = "UPDATE tb_hotel SET nm_hotel = ?, endereco = ?, qtd_estrelas = ? WHERE id_hotel = ? ";
            st = conn.prepareStatement(sql);
            st.setString(1, hotel.getNmHotel());
            st.setString(2, hotel.getEndereco());
            st.setInt(3, hotel.getQtdEstrelas());
            st.setInt(4, hotel.getIdHotel());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new HotelException(PostsSystems.getPost("erro02") + e.getMessage());
        } finally {
            DB.closeStatment(st);
        }

        return hotel;
    }

    public void delete(Integer id) throws HotelException {

        PreparedStatement st = null;
        try {
            String sql = "DELETE FROM tb_hotel WHERE id_hotel = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new HotelException(PostsSystems.getPost("erro02") + e.getMessage());
        } finally {
            DB.closeStatment(st);
        }
    }
}
