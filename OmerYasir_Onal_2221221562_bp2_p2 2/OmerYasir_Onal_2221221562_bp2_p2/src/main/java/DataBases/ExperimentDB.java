/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBases;

import Classes.Experiment;
import Classes.Material;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author omeryasironal
 */
public class ExperimentDB {

    public static int addExperiment(Experiment experiment) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "INSERT INTO Deneyler (deneyAdi, deneyTarihi) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, experiment.getExperimentName());
            pstmt.setInt(2, experiment.getExperimentDate());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                return id;
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public static Experiment getExperimentById(int id) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT * FROM Deneyler WHERE deneyId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Experiment experiment = new Experiment();
                experiment.setId(rs.getInt("deneyId"));
                experiment.setExperimentName(rs.getString("deneyAdi"));
                experiment.setExperimentDate(rs.getInt("deneyTarihi"));
                return experiment;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public static boolean deleteExperiment(int id) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "DELETE FROM material_tracking_system_db.Deneyler WHERE deneyId = ?";
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
        ArrayList<Material> materialArrayList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT * FROM system_db.tbl_materials WHERE material_name LIKE ? OR material_type LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + search + "%");
            pstmt.setString(2, "%" + search + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Material material = new Material();
                material.setId(rs.getInt("id"));
                material.setMaterialName(rs.getString("material_name"));
                material.setMaterialType(rs.getString("material_type"));
                material.setStockStatus(rs.getInt("stock_status"));
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

    public static ArrayList<Experiment> getExperiments() {
        Connection conn = null;
        ArrayList<Experiment> experiments = new ArrayList<Experiment>();
        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT * FROM material_tracking_system_db.Deneyler";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Experiment experiment = new Experiment();
                experiment.setId(rs.getInt("deneyId"));
                experiment.setExperimentName(rs.getString("deneyAdi"));
                experiment.setExperimentDate(rs.getInt("deneyTarihi"));
                experiments.add(experiment);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DBConnection.closeConnection();
        }
        return experiments;
    }

    public static ArrayList<Experiment> searchByNameOrTypeExperiments(String search) {
        ArrayList<Experiment> experimentArrayList = new ArrayList<Experiment>();
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT * FROM material_tracking_system_db.Deneyler WHERE deneyAdi LIKE ? OR deneyTarihi LIKE ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + search + "%");
            pstmt.setString(2, "%" + search + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Experiment experiment = new Experiment();
                experiment.setId(rs.getInt("deneyId"));
                experiment.setExperimentName(rs.getString("deneyAdi"));
                experiment.setExperimentDate(rs.getInt("deneyTarihi"));
                experimentArrayList.add(experiment);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DBConnection.closeConnection();
        }
        return experimentArrayList;
    }

    public static boolean addMaterialToExperiment(int experimentId, Material material, int count) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "INSERT INTO DeneyMalzemeleri (experimentId, materialId, materialCount) VALUES (?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE materialCount = materialCount + VALUES(materialCount)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, experimentId);
            pstmt.setInt(2, material.getId());
            pstmt.setInt(3, count);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public static boolean removeMaterialFromExperiment(int experimentId, Material material) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "UPDATE DeneyMalzemeleri SET materialCount = materialCount - 1 WHERE deneyId = ? AND malzemeId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, experimentId);
            pstmt.setInt(2, material.getId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public static List<Map.Entry<String, Integer>> getMaterialsForExperiment(int experimentId) {
        List<Map.Entry<String, Integer>> materials = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT m.materialName, dm.materialCount FROM DeneyMalzemeleri dm "
                    + "JOIN Malzemeler m ON dm.materialId = m.materialId "
                    + "WHERE dm.experimentId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, experimentId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String materialName = rs.getString("materialName");
                int count = rs.getInt("materialCount");
                materials.add(new AbstractMap.SimpleEntry<>(materialName, count));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DBConnection.closeConnection();
        }
        return materials;
    }

}
