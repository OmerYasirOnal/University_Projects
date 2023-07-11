/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages;

import DataBases.MaterialDB;
import Classes.Material;
import Classes.User;
import javax.swing.JOptionPane;

/**
 *
 * @author omeryasironal
 */
public class MaterialAddingPage extends javax.swing.JFrame {
    MaterialsPage mp;
    StartPage sp;
    User user;
    
    public MaterialAddingPage(MaterialsPage mp,User user, StartPage sp) {
        this.mp = mp;
        this.user=user;
        this.sp = sp;
        initComponents();
        this.setLocation(300, 400);

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new javax.swing.JPanel();
        txt_name = new javax.swing.JTextField();
        cmb_type = new javax.swing.JComboBox<>();
        spnr_stock = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        cmb_year = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(307, 341));
        setPreferredSize(new java.awt.Dimension(307, 341));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Maleme Ekleme Sayfası", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 3, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 120, -1));

        cmb_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cam Malzeme", "Plastik Malzeme", "Termometre", "Elektronik Cihaz", "Ölçüm Cihazı", "Kimyasal Madde", "Koruyucu Ekipman" }));
        jPanel1.add(cmb_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 120, -1));

        spnr_stock.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        jPanel1.add(spnr_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 120, -1));

        jLabel4.setText("Malzeme Alış Tarihi");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel3.setText("tür");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jLabel2.setText("isim");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLabel5.setText("Stok Sayısı");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        btn_add.setText("Ekle");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 220, 30));

        btn_back.setText("Geri");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel1.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 20));

        cmb_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));
        jPanel1.add(cmb_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 120, -1));

        getContentPane().add(jPanel1);

        pack();
    }//GEN-END:initComponents

    // Bir önceki sayfaya yönlendirir
    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        MaterialsPage mp = new MaterialsPage(this.sp, this.user);
        mp.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    // İlgili yerlere girilen bilgiler ile yeni bir malzeme oluşturur ve bunu veritabanına ekler
    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        String name = txt_name.getText();
        String type = cmb_type.getSelectedItem().toString();
        int stock = (int) this.spnr_stock.getValue();
        String selectedItem = (String) cmb_year.getSelectedItem();
        int date = Integer.parseInt(selectedItem);
        Material m = new Material(name, type, stock, date);
        if (MaterialDB.addMaterial(m)) {
            JOptionPane.showMessageDialog(this, "Malzeme başarıyla eklendi.", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Malzeme zaten listede mevcut!.", "Uyarı!", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btn_addActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JComboBox<String> cmb_type;
    private javax.swing.JComboBox<String> cmb_year;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner spnr_stock;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables
}
