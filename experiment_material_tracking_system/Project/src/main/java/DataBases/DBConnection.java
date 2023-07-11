/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author omeryasironal
 */
public class DBConnection {

    private static String connectionString = "jdbc:mysql://127.0.0.1:3306/material_tracking_system_db?user=root&password=rootfsmblm";
    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(connectionString);
            }
        } catch (SQLException e) {
            System.out.println("Veritabanına bağlanılamadı!");
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Veritabanı bağlantısı kapatılamadı!");
            e.printStackTrace();
        }
    }
}

