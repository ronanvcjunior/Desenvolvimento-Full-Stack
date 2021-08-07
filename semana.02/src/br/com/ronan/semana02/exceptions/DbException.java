package br.com.ronan.semana02.exceptions;

import java.lang.reflect.Constructor;

public class DbException extends RuntimeException {

    private  static long serialVersionUID = 1L;

    public DbException(String msg) {
        super(msg);
    }
}
