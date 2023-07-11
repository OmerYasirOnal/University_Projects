/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author omeryasironal
 */
public class ÖmerYasirÖnal_GameButton extends JButton {

    private final int row;
    private final int col;
    private String stone;

    public ÖmerYasirÖnal_GameButton(int row, int col) {
        this.row = row;
        this.col = col;
        this.stone = "-";
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getStone() {
        return stone;
    }

    public void setStone(String stone) {
        this.stone = stone;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Taşın renksiz olup olmadığını kontrol eder
        if (!stone.equals("-")) {

            //Graphics nesnesini iki boyutlu olan "Graphics2D" nesnesine dönüştürür
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int padding = 10;
            int diameter = Math.min(getWidth(), getHeight()) - 2 * padding;

            // Taşın rengini belirleyerek, siyah veya beyaz olarak ayarlar
            if (stone.equals("B")) {
                g2d.setColor(Color.BLACK);
            } else {
                g2d.setColor(Color.WHITE);
            }

            // Belirlenen renkte ve boyutta bir daire çizer
            g2d.fillOval(padding, padding, diameter, diameter);
        }
    }
}
