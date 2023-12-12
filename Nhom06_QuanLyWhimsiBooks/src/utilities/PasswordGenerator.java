/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author duong
 */
public class PasswordGenerator {

    public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static String generatePassword(int maxLength) {
        int minLength = 8;
        int length = minLength + new Random().nextInt(maxLength - minLength + 1);
        return generateRandomString(length);
    }

}
