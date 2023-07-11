/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages;

import DataBases.UserDB;
import Classes.User;
import javax.swing.JOptionPane;

/**
 *
 * @author omeryasironal
 */
public class SingupPage extends javax.swing.JFrame {

    /**
     * Creates new form SingupPage
     */
    public SingupPage() {
        initComponents();
        this.setLocation(300, 400);

    }

  
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtPassword = new javax.swing.JPanel();
        btn_back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();
        txt_userName = new javax.swing.JTextField();
        btn_register = new javax.swing.JButton();
        btn_teacher = new javax.swing.JRadioButton();
        btn_assistant = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(320, 320));
        setMinimumSize(new java.awt.Dimension(317, 338));
        setPreferredSize(new java.awt.Dimension(317, 338));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kayıt Ekranı", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 3, 12))); // NOI18N
        txtPassword.setPreferredSize(new java.awt.Dimension(400, 400));
        txtPassword.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_back.setText("Geri");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        txtPassword.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 70, -1));

        jLabel3.setText("Kullanıcı Adı:");
        txtPassword.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel4.setText("Şifre:");
        txtPassword.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        txt_password.setToolTipText("Şifre, en az bir büyük harf, bir küçük harf ve bir rakam içerebilir");
        txtPassword.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 130, 30));

        txt_userName.setToolTipText("Kullanıcı adı, sadece harf ve rakam içerebilir");
        txtPassword.add(txt_userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 130, 30));

        btn_register.setText("Kayıt Ol");
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });
        txtPassword.add(btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 140, 40));

        buttonGroup1.add(btn_teacher);
        btn_teacher.setText("Öğretmen");
        txtPassword.add(btn_teacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        buttonGroup1.add(btn_assistant);
        btn_assistant.setSelected(true);
        btn_assistant.setText("Asistan");
        txtPassword.add(btn_assistant, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        getContentPane().add(txtPassword);

        pack();
    }//GEN-END:initComponents

    // Kayıt ekranını kapatır ve giriş ekranına döner
    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();

    }//GEN-LAST:event_btn_backActionPerformed

    // Kullanıcın sisteme kayıt olmasını sağlar 
    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        String user_name = txt_userName.getText();
        String password = txt_password.getText();
        String isAdmin = btn_teacher.isSelected() ? "öğretmen" : "asistan";

        // Kullanıcı adı ve şifrenin düzgün formatlandığını kontrol eder
        if (validateUserName(user_name) && validatePassword(password)) {
            User user = new User(user_name, password, isAdmin);
            UserDB.register(user);

            LoginPage lp = new LoginPage();
            lp.setVisible(true);
            dispose();
        } else {
            // Eğer format yanlışsa, kullanıcıyı uyarır
            JOptionPane.showMessageDialog(this, "Giriş başarısız: Kullanıcı adı veya şifre uygun formatta değil", "Uyarı!", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btn_registerActionPerformed

    // Kullanıcı adı için sadece harf ve rakam içeren bir düzen belirlenir
    private boolean validateUserName(String username) {
        String regex = "^[a-zA-Z0-9_]+$";
        return username.matches(regex);
    }

    // Şifre için en az bir büyük harf, bir küçük harf ve bir rakam içeren bir düzen belirlenir
    private boolean validatePassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        return password.matches(regex);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btn_assistant;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_register;
    private javax.swing.JRadioButton btn_teacher;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel txtPassword;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_userName;
    // End of variables declaration//GEN-END:variables
}
