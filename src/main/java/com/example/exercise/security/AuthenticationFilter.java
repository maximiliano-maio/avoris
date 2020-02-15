package com.example.exercise.security;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            BufferedReader reader = request.getReader();
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String parsedReq = sb.toString();
            if (parsedReq != null) {
                ObjectMapper mapper = new ObjectMapper();
                AuthReq authReq = mapper.readValue(parsedReq, AuthReq.class);
                return new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new InternalAuthenticationServiceException("Failed to parse authentication request body");
        }
        return null;
    }

    
    public static class AuthReq {
        String username;
        String password;

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }


}

