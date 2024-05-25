package com.sam.TaskTrek.utils;

import com.sam.TaskTrek.security.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderUtil {
   
   
    public static void main(String[] args) {
       
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        System.out.println(passwordEncoder.encode("sam"));
        System.out.println(passwordEncoder.encode("admin"));


    }
}
