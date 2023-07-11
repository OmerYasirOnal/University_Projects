/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author omeryasironal
 */
// User bilgilerini bir arada tutan bir sınıftır
public class ÖmerYasirÖnal_User {

    private String mail;
    private String username;
    private String password;
    private int score;

    public ÖmerYasirÖnal_User(String mail, String username, String password, int score) {
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.score = score;
    }

    public ÖmerYasirÖnal_User(String userName, int score) {
        this.username = userName;
        this.score = score;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
