package br.com.lf.sprint.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder password = new BCryptPasswordEncoder();
        System.out.println(password.encode("lara"));
    }
}
