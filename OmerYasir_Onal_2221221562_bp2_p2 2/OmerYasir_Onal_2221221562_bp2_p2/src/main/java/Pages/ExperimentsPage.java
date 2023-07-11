/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages;

import DataBases.ExperimentDB;
import Classes.Experiment;
import Classes.User;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author omeryasironal
 */

/*
Kullanıcının deneyleri görebildiği ve yönetebildiği sayfa.
 */
public class ExperimentsPage extends javax.swing.JFrame {

    DefaultTableModel tbl_table_model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    User user;
    StartPage sp;

    public ExperimentsPage() {
        initComponents();
        configureTableModel();
        fillTable();
        this.setLocation(500, 500);

    }

    public ExperimentsPage(User user, StartPage sp) {
        initComponents();
        configureTableModel();
        fillTable();
        this.user = user;
        if (user.getType().equals("öğretmen")) {
            btn_create.setEnabled(true);
        } else {
            btn_create.setEnabled(false);
        }
        this.sp = sp;
        this.setLocation(300, 400);

    }

    // Tablonun kolon isimlerini belirler ve ekler
    private void configureTableModel() {
        tbl_table_model.addColumn("Id");
        tbl_table_model.addColumn("Deney Adı");
        tbl_table_model.addColumn("Deney Yapılış Tarihi");
    }

    // Deneyler tablosuna MySQL'den tüm deneyleri ve bilgilerini çeker.
    private void fillTable() {
        ArrayList<Experiment> experiments = ExperimentDB.getExperiments();
        tbl_table_model.setRowCount(0);

        for (Experiment experiment : experiments) {
            // ID, isim, tip, stok ve tarih bilgilerini sırasıyla ekliyoruz
            tbl_table_model.addRow(new Object[]{experiment.getId(), experiment.getExperimentName(), experiment.getExperimentDate()});
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new javax.swing.JPanel();
        btn_create = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        btn_detail = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(125, 225));
        setMinimumSize(new java.awt.Dimension(684, 381));
        setSize(new java.awt.Dimension(684, 381));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deney Yönetim Ekranı", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 3, 12))); // NOI18N
        jPanel1.setToolTipText("");
        jPanel1.setMinimumSize(new java.awt.Dimension(684, 381));
        jPanel1.setPreferredSize(new java.awt.Dimension(684, 381));
        jPanel1.setSize(new java.awt.Dimension(684, 381));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_create.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        btn_create.setText("Deney Oluştur");
        btn_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createActionPerformed(evt);
            }
        });
        jPanel1.add(btn_create, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 180, 40));

        btn_remove.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        btn_remove.setText("Deney Sil");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 180, 40));

        btn_detail.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        btn_detail.setText("Deney Detaylarını Gör");
        btn_detail.setToolTipText("");
        btn_detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_detailActionPerformed(evt);
            }
        });
        jPanel1.add(btn_detail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 180, 40));

        jTable1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTable1.setModel(tbl_table_model);
        jTable1.setToolTipText("");
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 400, 230));

        txt_search.setToolTipText("Deney Adı veya Yılı ile Arayabilirsiniz");
        jPanel1.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 130, 30));

        btn_search.setText("Arama");
        btn_search.setToolTipText("");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        jPanel1.add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 90, 30));

        btn_back.setText("Geri");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel1.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 90, 30));

        getContentPane().add(jPanel1);

        pack();
    }//GEN-END:initComponents

    // Deney oluşturma sayfasına yönlendirir
    private void btn_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createActionPerformed
        ExperimentCreatingPage ecp = new ExperimentCreatingPage(this, this.user, this.sp);
        ecp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_createActionPerformed

    // Tabloda seçilmiş olan deneyi tablodan ve veritbanından siler
    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed

        int row = jTable1.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Lütfen silmek istediğiniz malzemeyi seçiniz.", "Uyarı!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int id = (int) jTable1.getValueAt(row, 0);
            ExperimentDB.deleteExperiment(id);
            tbl_table_model.removeRow(row);
            JOptionPane.showMessageDialog(this, "Malzeme silindi.", "Bilgi!", JOptionPane.INFORMATION_MESSAGE);
        }

        jTable1.repaint();
    }//GEN-LAST:event_btn_removeActionPerformed

    // Tabloda seçilmiş olan deneyde kullanılan malzemeleri veritbanından çeker ve gösterir
    private void btn_detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detailActionPerformed
        Experiment selectedExperiment = getSelectedExperimentForShowDetail();

        if (selectedExperiment != null) {
            // Deneye ait malzemeleri veritabanından çeker
            List<Map.Entry<String, Integer>> materials = ExperimentDB.getMaterialsForExperiment(selectedExperiment.getId());

            // Malzemeleri ve kullanılan miktarını gösterir
            StringBuilder message = new StringBuilder();
            for (Map.Entry<String, Integer> material : materials) {
                message.append(material.getKey()).append(" (Adet: ").append(material.getValue()).append(")\n");
            }

            JOptionPane.showMessageDialog(this, message, "Deney Adı: " + selectedExperiment.name, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen bir deney seçin.", "Uyarı!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_detailActionPerformed

    // Tablodan kullanıcın seçmiş olduğu deneyin satır değerini bulur.
    private Experiment getSelectedExperimentForShowDetail() {
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Lütfen detaylarını görmek istediğiniz deneyi seçiniz.", "Uyarı!", JOptionPane.INFORMATION_MESSAGE);
            return null;
        } else {
            int id = (int) jTable1.getValueAt(row, 0);
            Experiment experiment = ExperimentDB.getExperimentById(id);
            return experiment;
        }
    }


    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed

        String search = txt_search.getText();
        tbl_table_model.setRowCount(0);

        ArrayList<Experiment> experimentList = ExperimentDB.searchByNameOrTypeExperiments(search);

        for (Experiment experiment : experimentList) {
            tbl_table_model.addRow(new Object[]{experiment.getId(), experiment.name, experiment.date});
        }

    }//GEN-LAST:event_btn_searchActionPerformed

    // StartPage sayfasına gider
    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        sp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_create;
    private javax.swing.JButton btn_detail;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_search;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}