package br.com.ronan.semana04.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {

    public java.sql.Date formatDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        java.sql.Date dateSql = null;
        try {
            java.util.Date dateSDF = sdf.parse(dateStr);
            long ms = dateSDF.getTime();
            dateSql = new java.sql.Date(ms);

            return dateSql;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
