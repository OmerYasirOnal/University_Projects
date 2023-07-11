/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBases;

import Classes.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author omeryasironal
 */
public class UserDB {
    
    public static boolean register(User user) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "INSERT INTO material_tracking_system_db.Kullanıcılar (userId, userName, password, type) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.id);
            pstmt.setString(2, user.name);
            pstmt.setString(3, user.password);
            pstmt.setString(4, user.type);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public static User login(User user) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT * FROM material_tracking_system_db.Kullanıcılar WHERE userName = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.name);
            pstmt.setString(2, user.password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String userType = rs.getString("type");
                User authenticatedUser = new User(user.name, user.password, userType);
                return authenticatedUser;
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBConnection.closeConnection();
        }
    }
}
