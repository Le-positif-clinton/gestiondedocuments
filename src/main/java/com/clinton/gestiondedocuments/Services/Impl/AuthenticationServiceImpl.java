package com.clinton.gestiondedocuments.Services.Impl;

import com.clinton.gestiondedocuments.Services.AuthenticationService;
import com.clinton.gestiondedocuments.Services.auth.ApplicationUserDetailsService;
import com.clinton.gestiondedocuments.dto.auth.AuthenticationRequest;
import com.clinton.gestiondedocuments.dto.auth.AuthenticationResponse;
import com.clinton.gestiondedocuments.model.auth.ExtendedUser;
import com.clinton.gestiondedocuments.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private AuthenticationManager authenticationManager;


    private ApplicationUserDetailsService userDetailsService;


    private JwtUtil jwtUtil;
    @Override
    public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());

        final String jwt = jwtUtil.generateToken((ExtendedUser) userDetails);

        return ResponseEntity.ok(AuthenticationResponse.builder().accesToken(jwt).build());
    }
}
