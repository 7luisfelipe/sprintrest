package br.com.lf.sprint.secutiry;

import java.util.concurrent.TimeUnit;

public class SecurityConstants {
    //public -- Não precisa ser usado se for acessado de classes do mesmo pacote
     static final String SECRETE = "sucessoCroft";
     static final String TOKEN_PREFIX = "Bearer ";
     static final String HEADER_STRING = "Authorization";
     static final String SIGN_UP_URL = "/users/sign-up";
     static final long EXPIRATION_TIME = 86400000l;

     /*
    public static void main(String[] args) {
        System.out.println(TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
    }
    */
}
