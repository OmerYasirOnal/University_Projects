/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omeryasironal
 */
public final class ÖmerYasirÖnal_MyTableModel extends DefaultTableModel {

    String filename;

    public ÖmerYasirÖnal_MyTableModel(String filename) {
        super(new String[]{"Users", "Scores"}, 0);
        this.filename = filename;
        loadFromFile();
    }

    // Skor tablosundaki değerleri tablo üzerinden değiştirilemez yapar
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    // 'score.txt' dosyasındaki verileri okur ve kaydedilen skorları tabloya yazar 
    public void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(":\\s*");
                if (values.length == 2) {
                    try {
                        String key = values[0].trim();
                        int value = Integer.parseInt(values[1].trim());
                        this.addRow(new Object[]{key, value});
                    } catch (NumberFormatException e) {
                        System.err.println("Hata: Geçersiz sayısal değer: " + line);
                    }
                } else {
                    System.err.println("Hata: Geçersiz anahtar-değer çifti: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Secili satırı skor dosyasından siler ve tabloyu günceller
    public void deleteRowFromFile(int row) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
            String line;
            int currentRow = 0;
            while ((line = br.readLine()) != null) {
                if (currentRow != row) {
                    lines.add(line);
                }
                currentRow++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        removeRow(row);
        fireTableRowsDeleted(row, row);

        // Silinen değerden sonra tablonun durumunu günceller
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.filename))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
