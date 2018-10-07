package ru.xpendence.streamcast.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.10.18
 * Time: 15:57
 * e-mail: 2262288@gmail.com
 */
public class PasswordUtils {

    public static String encode(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    public static void main(String[] args) {
        System.out.println(encode("admin"));
    }
}
