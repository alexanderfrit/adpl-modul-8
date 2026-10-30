package model;

import java.sql.*;

public class Database {
    static final String url = "jdbc:mysql://localhost:3306/moduladpl";
    static final String user = "root";
    static final String pass = "";
    static Connection conn;
    public static Statement stmt;
    public static ResultSet rs;

    public void connect() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
        }
    }

    public void query(String sql) {
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Kesalahan Query: " + ex.getMessage());
        }
    }

    public ResultSet view(String sql) {
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Kesalahan View: " + ex.getMessage());
        }
        return rs;
    }

    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Kesalahan saat menutup koneksi: " + ex.getMessage());
        }
    }
}