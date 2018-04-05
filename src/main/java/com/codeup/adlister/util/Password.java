package com.codeup.adlister.util;

import org.mindrot.jbcrypt.BCrypt;

public class Password {
    private static final int ROUNDS = 12;

    public static String hash(String password) {
        int numberOfRounds = 12;
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(numberOfRounds));
        return hash;
    }

    public static boolean check(String password, String hash) {
        String hashpass = hash;
        boolean passwordsDoMatch = BCrypt.checkpw(password, hash);
        return passwordsDoMatch;
    }
}
