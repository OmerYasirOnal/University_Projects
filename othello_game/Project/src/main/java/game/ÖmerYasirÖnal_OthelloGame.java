/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package game;

import java.awt.*;

/**
 *
 * @author omeryasironal
 */
// Oyunu "OthelloGameLogic" methodlarındaki kurallara göre çalıştıran sınıftır
public class ÖmerYasirÖnal_OthelloGame extends javax.swing.JFrame {

    private final int boardSize;
    private final ÖmerYasirÖnal_GameButton[][] boardButtons;
    private final String user_1;
    private final ÖmerYasirÖnal_OthelloGameLogic gameLogic;

    public ÖmerYasirÖnal_OthelloGame(int value, String user_1, String user_2, ÖmerYasirÖnal_StartPage backPage) {

        initComponents();
        setLocation(new java.awt.Point(400, 50));
        boardSize = value;
        boardPanel.setLayout(new GridLayout(value, value));
        boardButtons = new ÖmerYasirÖnal_GameButton[value][value];
        gameLogic = new ÖmerYasirÖnal_OthelloGameLogic(boardSize, boardButtons, boardPanel, userLabel, user_1, user_2, backPage, this);
        initBoard();
        drawBoard();
        this.user_1 = user_1;
        userLabel.setText(this.user_1 + "'nin sırası!");

    }

    private void initBoard() {
        gameLogic.initBoard();
    }

    private void drawBoard() {
        gameLogic.drawBoard();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        boardPanel = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setLocation(new java.awt.Point(100, 100));
        setMinimumSize(new java.awt.Dimension(422, 463));

        boardPanel.setBackground(new java.awt.Color(102, 204, 0));
        boardPanel.setForeground(new java.awt.Color(153, 204, 0));
        boardPanel.setPreferredSize(new java.awt.Dimension(100, 100));
        boardPanel.setVerifyInputWhenFocusTarget(false);
        boardPanel.setLayout(new java.awt.GridLayout(1, 0));

        userLabel.setText("jLabel1");

        jMenu1.setText("Oyun");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Yeniden Başlat");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(boardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(boardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        boardPanel.getAccessibleContext().setAccessibleName("");
        boardPanel.getAccessibleContext().setAccessibleDescription("");

        pack();
    }//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        newGame();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private void newGame() {
        gameLogic.newGame();
    }

    void isVisible(boolean b) {
        this.setVisible(b);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boardPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
