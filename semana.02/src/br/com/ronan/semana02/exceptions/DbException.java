package br.com.ronan.semana02.exceptions;


public class DbException extends RuntimeException {

    private  static long serialVersionUID = 1L;

    public DbException(String msg) {
        super(msg);
    }
}
