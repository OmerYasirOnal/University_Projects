/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omeryasironal
 */
// Oyunun düzgün çalışmasını sağlayan ve kontrollerinin sağlandığı sınıftır
public class ÖmerYasirÖnal_OthelloGameLogic {

    private JFrame gameFrame;
    private final int boardSize;
    private final String[][] board;
    private final game.ÖmerYasirÖnal_GameButton[][] boardButtons;
    private final JPanel boardPanel;
    private String currentPlayer;
    private final JLabel userLabel;
    private final String user_1;
    private final String user_2;
    private final JFrame backPage;

    public ÖmerYasirÖnal_OthelloGameLogic(int boardSize, game.ÖmerYasirÖnal_GameButton[][] boardButtons, JPanel boardPanel,
            JLabel userLabel, String user_1, String user_2, JFrame backPage, JFrame gameFrame) {
        this.gameFrame = gameFrame;
        this.boardSize = boardSize;
        this.boardButtons = boardButtons;
        this.boardPanel = boardPanel;
        this.userLabel = userLabel;
        this.user_1 = user_1;
        this.user_2 = user_2;
        this.backPage = backPage;
        this.board = new String[boardSize][boardSize];
        this.currentPlayer = "B";
    }

    // Oyunun başlangıç durumunu yaratır
    void initBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if ((i == boardSize / 2 - 1 && j == boardSize / 2 - 1) || (i == boardSize / 2 && j == boardSize / 2)) {
                    board[i][j] = "B";
                } else if ((i == boardSize / 2 - 1 && j == boardSize / 2) || (i == boardSize / 2 && j == boardSize / 2 - 1)) {
                    board[i][j] = "W";
                } else {
                    board[i][j] = "-";
                }
            }
        }
    }

    // Tahta üzerinde yapılan her hamleden sonra tahtayı günceller
    void updateBoard(int row, int col) {
        game.ÖmerYasirÖnal_GameButton button = boardButtons[row][col];
        button.setStone(board[row][col]);
        if (board[row][col].equals("B")) {
            button.setBackground(new Color(34, 139, 34));
        } else if (board[row][col].equals("W")) {
            button.setBackground(new Color(34, 139, 34));
        } else {
            button.setBackground(new Color(34, 139, 34));
        }
        button.repaint();
    }

    // Rakip oyuncunun beyaz mı? yoksa siyah mı? olduğunu belirler
    String getOpponent(String player) {
        return (player.equals("B")) ? "W" : "B";
    }

    // Kullanıcı yalnızca taşların olduğu hücrelerin etrafındaki hücrelere taş koyabilir
    boolean checkDirection(int row, int col, int rowIncrement, int colIncrement, String player) {
        int newRow = row + rowIncrement;
        int newCol = col + colIncrement;
        if (newRow >= 0 && newRow < boardSize && newCol >= 0 && newCol < boardSize) {
            if (board[newRow][newCol].equals(getOpponent(player))) {
                newRow += rowIncrement;
                newCol += colIncrement;
                while (newRow >= 0 && newRow < boardSize && newCol >= 0 && newCol < boardSize) {
                    if (board[newRow][newCol].equals(player)) {
                        return true;
                    } else if (board[newRow][newCol].equals("-")) {
                        break;
                    }
                    newRow += rowIncrement;
                    newCol += colIncrement;
                }
            }
        }
        return false;
    }

    void checkFlip(int row, int col) {

        // 8 farklı yönde kontrol yapar
        int[][] increments = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int[] increment : increments) {
            int rowIncrement = increment[0];
            int colIncrement = increment[1];

            // Belirlenen yöndeki hangi taşların çevrilebileceğini kontrol eder
            if (checkDirection(row, col, rowIncrement, colIncrement, currentPlayer)) {
                int newRow = row + rowIncrement;
                int newCol = col + colIncrement;

                // Belirtilen yöndeki hücrelerde rakip oyuncunun taşları olduğu sürece döngü devam eder
                while (board[newRow][newCol].equals(getOpponent(currentPlayer))) {

                    // Döngüdeki mevcut hücredeki taş, mevcut oyuncunun taşıyla değiştirilir
                    board[newRow][newCol] = currentPlayer;

                    // Değiştirilen taşlar tahtada güncellenir
                    updateBoard(newRow, newCol);
                    newRow += rowIncrement;
                    newCol += colIncrement;
                }
            }
        }
    }

    void drawBoard() {

        // İki for döngüsü ile tahta boyutu kadar hücre gezer
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {

                // Her hücre için özel bir "GameButton" nesnesi oluşturur
                ÖmerYasirÖnal_GameButton button = new ÖmerYasirÖnal_GameButton(i, j);
                button.setPreferredSize(new Dimension(70, 70));
                button.setOpaque(true);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

                // Buttona, oyun tahtasındaki ilgili hücrenin taş değeri atanır
                String stone = board[i][j];
                button.setStone(stone);

                button.setBackground(new Color(34, 139, 34));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        // Tıklanan button nesnesine erişir
                        ÖmerYasirÖnal_GameButton button = (ÖmerYasirÖnal_GameButton) e.getSource();

                        // Tıklanan buttonun satır ve sütun değeri alınır
                        int row = button.getRow();
                        int col = button.getCol();

                        try {
                            handleButtonClick(row, col);
                        } catch (IOException ex) {
                            Logger.getLogger(ÖmerYasirÖnal_OthelloGameLogic.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                });

                // Oluşturulan buttonları kullanabilmek ve görebilmek için "boardButtons" ve "boardPanel" nesnelerine eklenir
                boardButtons[i][j] = button;
                boardPanel.add(button);
            }
        }
    }

    /**
     * Tıklanan hücrenin etrafındaki 8 komşu hücreden en az birinin dolu olup
     * olmadığını kontrol eder
     */
    boolean isAdjacent(int row, int col) {
        int[][] increments = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int[] increment : increments) {
            int newRow = row + increment[0];
            int newCol = col + increment[1];

            if (newRow >= 0 && newRow < boardSize && newCol >= 0 && newCol < boardSize) {
                if (!board[newRow][newCol].equals("-")) {
                    return true;
                }
            }
        }
        return false;
    }

    // Buttonlardan birine tıklandığında gerçekleştirelecek işlemleri yönetir
    void handleButtonClick(int row, int col) throws IOException {
        if (board[row][col].equals("-") && isAdjacent(row, col)) {
            board[row][col] = currentPlayer;
            updateBoard(row, col);
            checkFlip(row, col);
            currentPlayer = (currentPlayer.equals("B")) ? "W" : "B";
            userLabel.setText((currentPlayer.equals("B") ? user_1 : user_2) + "'s turn");
        }

        // Oyunun bitip bitmediğini kontrol eder
        if (isGameOver()) {
            int[] scores = calculateScores();
            saveScores(scores[0], scores[1]);
            showEndGameDialog(scores[0], scores[1]);
        }
    }

    // Tahtadaki hücreleri dolaşarak geçerli bir hamlenin olup olmadığını kontrol eder
    boolean isGameOver() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j].equals("-") && isAdjacent(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Oyun sonunda tahtada bulununan siyah ve beyaz sayısını ait oluduğu
     * kullanıcının adıyla 'score.txt' dosyasına kayıt eder
     */
    void saveScores(int blackScore, int whiteScore) throws IOException {
        FileWriter fileWriter = new FileWriter("scores.txt", true);
        try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(user_1 + ": " + blackScore + "\n" + user_2 + ": " + whiteScore);
        }
    }

    // Tahtadaki siyah ve beyaz taşların sayısını hesaplar
    int[] calculateScores() {
        int blackScore = 0;
        int whiteScore = 0;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j].equals("B")) {
                    blackScore++;
                } else if (board[i][j].equals("W")) {
                    whiteScore++;
                }
            }
        }
        return new int[]{blackScore, whiteScore};
    }

    // Oyun sonunda, kullanıcıya devam etmek isteyip istemediğini sorar
    void showEndGameDialog(int blackScore, int whiteScore) {

        String message = "game Over!\nBlack: " + blackScore + "\nWhite: " + whiteScore + "\n\nDo you want to play again?";
        int response = JOptionPane.showConfirmDialog(null, message, "game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch (response) {
            case JOptionPane.YES_OPTION ->
                newGame();
            case JOptionPane.NO_OPTION -> {
                backPage.setVisible(true);
                gameFrame.setVisible(false);
            }
            default ->
                gameFrame.dispose();
        }
    }

    // Tahtayı ve dahil olan herşeyi sıfırlayarak oyunu yeniden başlatır
    void newGame() {
        boardPanel.removeAll();
        initBoard();
        drawBoard();
        currentPlayer = user_2 + "'nin sırası!";
        userLabel.setText(currentPlayer);
        boardPanel.revalidate();
        boardPanel.repaint();
    }

}
