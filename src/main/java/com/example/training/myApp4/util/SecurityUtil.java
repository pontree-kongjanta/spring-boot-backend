package com.example.training.myApp4.util;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SecurityUtil {


    public static Optional<String> getCurrentUserId(){
        SecurityContext context = SecurityContextHolder.getContext();
        if(context == null){
            return Optional.empty();
        }

        Authentication authentication = context.getAuthentication();

        if(authentication == null){
            return Optional.empty();
        }

        Object principal = authentication.getPrincipal();
        if(principal == null){
            return Optional.empty();
        }

        String userID = (String) principal;

        return Optional.of(userID);
    }

}
