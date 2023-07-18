package com.clinton.gestiondedocuments.Services;

import com.clinton.gestiondedocuments.dto.ActionDto;
import com.clinton.gestiondedocuments.dto.auth.AuthenticationRequest;
import com.clinton.gestiondedocuments.dto.auth.AuthenticationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.List;

public interface AuthenticationService {

    ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request);


}
