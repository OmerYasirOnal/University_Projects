/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import game.ÖmerYasirÖnal_User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author omeryasironal
 */
public class ÖmerYasirÖnal_UserManager {

    /**
     * "findUserByName" methodu bir kullanıcı adı alır ve 'users.txt' dosyasında
     * bu kullanıcı adına sahip bir kullanıcıyı arar. Kullanıcıyı bulursa, bir
     * "ÖmerYasirÖnal_User" objesi oluşturur ve döndürür.
     */
    public ÖmerYasirÖnal_User findUserByName(String name) {
        File usersFile = new File("users.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(usersFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    String userEmail = values[0].trim();
                    String userName = values[1].trim();
                    String userPassword = values[2].trim();
                    if (userName.equals(name)) {
                        return new ÖmerYasirÖnal_User(userEmail, userName, userPassword, 0);
                    }
                } else {
                    System.err.println("Hata: Geçersiz kullanıcı bilgisi: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * "findUserByEmail" methodu, findUserByName methodunun aynısnı mail ile
     * yapar.
     */
    public ÖmerYasirÖnal_User findUserByEmail(String email) {
        File usersFile = new File("users.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(usersFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    String userEmail = values[0].trim();
                    String userName = values[1].trim();
                    String userPassword = values[2].trim();
                    if (userEmail.equals(email)) {

                        // Kullanıcıyı bulunursa yeni bir "ÖmerYasirÖnal_User" nesnesi oluşturur ve döndürür
                        return new ÖmerYasirÖnal_User(userEmail, userName, userPassword, 0);
                    }
                } else {
                    System.err.println("Hata: Geçersiz kullanıcı bilgisi: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Bu method, iki tane "ÖmerYasirÖnal_User" nesnesi alır ve bu nesnelerin
     * email adreslerinin eşit olup olmadığını kontrol eder. Eşitse true
     * değerini döndürür. Değilse false değerini döndürür.
     */
    public boolean usersIsSame(ÖmerYasirÖnal_User user1, ÖmerYasirÖnal_User user2) {
        if (user1 == null || user2 == null) {
            return false;
        }
        return user1.getMail().equals(user2.getMail());
    }

}
