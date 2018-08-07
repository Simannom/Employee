package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Simannom on 06.07.2018.
 */

public class JDBCEmployee {
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:postgresql://127.0.0.1:5432/EmployeeDB";
    private static final String user = "postgresql";
    private static final String password = "12345";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void create(String query)throws SQLException{
        if (con == null || stmt == null) throw new SQLException();
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void read (String query) throws SQLException{
        if (con == null || stmt == null) throw new SQLException();
        // executing query
        try {
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("" + count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void update (String query) throws SQLException{
        if (con == null || stmt == null) throw new SQLException();
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void delete (String query) throws SQLException{
        if (con == null || stmt == null) throw new SQLException();
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {


        try {
            //Загружаем драйвер
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");

            //Создаём соединение
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Соединение установлено");

            // getting Statement object to execute query
            stmt = con.createStatement();

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }

        }
    }

}
