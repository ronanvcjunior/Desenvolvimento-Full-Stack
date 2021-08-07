package br.com.ronan.semana02.dao;

import java.sql.*;

import br.com.ronan.semana02.business.PostsSystems;
import br.com.ronan.semana02.exceptions.DbException;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection() throws DbException {
        if (conn == null) {
            try {
                String url = PostsSystems.getPost("dburl");
                String password = PostsSystems.getPost("password");
                String user = PostsSystems.getPost("user");
                conn = DriverManager.getConnection(url, user, password);
                System.out.println(PostsSystems.getPost("ok01"));
            } catch (SQLException e) {
                System.err.println(PostsSystems.getPost("erro01"));
                System.out.println(e.getMessage());
            }

        }

        return conn;
    }

    public static void closeConnectoin() throws DbException {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatment(Statement st) throws DbException {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) throws DbException {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
