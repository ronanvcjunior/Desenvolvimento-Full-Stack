package br.com.ronan.semana02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.ronan.semana02.business.PostsSystems;
import br.com.ronan.semana02.entities.Hospedagem;
import br.com.ronan.semana02.entities.Hospede;
import br.com.ronan.semana02.entities.Quarto;
import br.com.ronan.semana02.exceptions.HospedagemException;

public class HospedagemDao {
    Connection conn;

    public HospedagemDao(Connection conn) {
        this.conn = conn;
    }

    public List<Hospedagem> findAll() throws HospedagemException {

        List<Hospedagem> retorno = new ArrayList<Hospedagem>();
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            String sql = "SELECT id_hospedagem, id_quarto, id_hospede, dt_checkin, dt_checkout FROM tb_hospedagem";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Hospedagem hospedagem = new Hospedagem(
                        rs.getInt("id_hospedagem"), 
                        new Quarto(rs.getInt("id_quarto")), 
                        new Hospede(rs.getInt("id_hospede")), 
                        rs.getDate("dt_checkin"), 
                        rs.getDate("dt_checkout"));

                retorno.add(hospedagem);
            }
        } catch (SQLException e) {
            throw new HospedagemException(PostsSystems.getPost("erro02") + e.getMessage());
        } finally {
            DB.closeStatment(st);
            DB.closeResultSet(rs);
        }
        return retorno;
    }

    public Hospedagem findById(Integer id) throws HospedagemException {
        
        Hospedagem retorno = new Hospedagem();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT id_hospedagem, id_quarto, id_hospede, dt_checkin, dt_checkout FROM tb_hospedagem WHERE id_hospedagem = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                retorno = new Hospedagem(
                        rs.getInt("id_hospedagem"), 
                        new Quarto(rs.getInt("id_quarto")),
                        new Hospede(rs.getInt("id_hospede")), 
                        rs.getDate("dt_checkin"), 
                        rs.getDate("dt_checkout"));
            }
        } catch (SQLException e) {
            throw new HospedagemException(PostsSystems.getPost("erro02") + e.getMessage());
        } finally {
            DB.closeStatment(st);
        }
        return retorno;
    }

    public Hospedagem insert(Hospedagem hospedagem) throws HospedagemException {
        
        PreparedStatement st = null;
        try {
            String sql = "INSERT INTO tb_hospedagem (id_quarto, id_hospede, dt_checkin, dt_checkout) VALUES (?, ?, ?, ?)";
            st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, hospedagem.getQuarto().getIdQuarto());
            st.setInt(2, hospedagem.getHospede().getIdHospede());
            st.setDate(3, hospedagem.getDtCheckin());
            st.setDate(4, hospedagem.getDtCheckout());
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    hospedagem.setIdHospedagem(rs.getInt(1));
                }
            } else {
                throw new HospedagemException(PostsSystems.getPost("erro03"));
            }
        } catch (SQLException e) {
            throw new HospedagemException(PostsSystems.getPost("erro02") + e.getMessage());
        } finally {
            DB.closeStatment(st);
        }
        return hospedagem;
    }

    public Hospedagem update(Hospedagem hospedagem) throws HospedagemException {

        PreparedStatement st = null;
        try {
            String sql = "UPDATE tb_hospedagem SET id_quarto = ?, id_hospede = ?, dt_checkin = ?, dt_checkout = ? WHERE id_hospedagem = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1, hospedagem.getQuarto().getIdQuarto());
            st.setInt(2, hospedagem.getHospede().getIdHospede());
            st.setDate(3, hospedagem.getDtCheckin());
            st.setDate(4, hospedagem.getDtCheckout());
            st.setInt(5, hospedagem.getIdHospedagem());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new HospedagemException(PostsSystems.getPost("erro02") + e.getMessage());
        } finally {
            DB.closeStatment(st);
        }
        return hospedagem;
    }

    public void delete(Integer id) throws HospedagemException {

        PreparedStatement st = null;
        try {
            String sql = "DELETE FROM tb_hospedagem WHERE id_hospedagem = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new HospedagemException(PostsSystems.getPost("erro02") + e.getMessage());
        } finally {
            DB.closeStatment(st);
        }
    }
}
