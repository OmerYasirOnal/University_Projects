/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBases;

import Classes.Material;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author omeryasironal
 */
public class MaterialDB {

    public static boolean addMaterial(Material material) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "INSERT INTO material_tracking_system_db.Malzemeler (materialId, materialName, materialType, materialStock, materialDate) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, material.getId());
            pstmt.setString(2, material.getMaterialName());
            pstmt.setString(3, material.getMaterialType());
            pstmt.setInt(4, material.getStockStatus());
            pstmt.setInt(5, material.getDate());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBConnection.closeConnection();
        }
    }

    
    
     public static ArrayList<Material> getMaterials() {
        ArrayList<Material> materials = new ArrayList<Material>();
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT * FROM material_tracking_system_db.Malzemeler";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Material material = new Material();
                material.setId(rs.getInt("materialId"));
                material.setMaterialName(rs.getString("materialName"));
                material.setStockStatus(rs.getInt("materialStock"));
                material.setMaterialType(rs.getString("materialType"));
                material.setDate(rs.getInt("materialDate"));

                materials.add(material);
            }
            return materials;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public static boolean deleteMaterial(int id) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "DELETE FROM material_tracking_system_db.Malzemeler WHERE materialId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public static ArrayList<Material> searchByNameOrTypeMaterials(String search) {
        ArrayList<Material> materialArrayList = new ArrayList<Material>();
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT * FROM material_tracking_system_db.Malzemeler WHERE materialName LIKE ? OR materialType LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + search + "%");
            pstmt.setString(2, "%" + search + "%");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Material material = new Material();
                material.setId(rs.getInt("materialId"));
                material.setMaterialName(rs.getString("materialName"));
                material.setMaterialType(rs.getString("materialType"));
                material.setStockStatus(rs.getInt("materialStock"));
                material.setDate(rs.getInt("materialDate"));

                materialArrayList.add(material);
            }
            return materialArrayList;
        } catch (Exception e) {
            System.out.println(e);
            return materialArrayList;
        } finally {
            DBConnection.closeConnection();
        }
    }


    public static Material getMaterialByName(String materialName) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT * FROM material_tracking_system_db.Malzemeler WHERE materialName = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, materialName);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Material material = new Material();
                material.setId(rs.getInt("materialId"));
                material.setMaterialName(rs.getString("materialName"));
                material.setStockStatus(rs.getInt("materialStock"));
                material.setMaterialType(rs.getString("materialType"));
                material.setDate(rs.getInt("materialDate"));

                return material;
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public static boolean addMaterialToStock(Material material) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "UPDATE Malzemeler SET materialStock = materialStock + 1 WHERE materialId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, material.getId());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public static boolean removeMaterialFromStock(Material material) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "UPDATE Malzemeler SET materialStock = materialStock - 1 WHERE materialId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, material.getId());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public static boolean updateMaterialStock(int materialId, int newStock) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "UPDATE Malzemeler SET materialStock = ? WHERE materialId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, newStock);
            pstmt.setInt(2, materialId);

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public static void setMaterialStock(Material material, int stock) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "UPDATE Malzemeler SET materialStock = ? WHERE materialName = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, stock);
            pstmt.setString(2, material.getMaterialName());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection();
        }
    }

}
