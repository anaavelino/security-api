package br.com.security.controller;

import br.com.security.infra.security.DadosTokenJWT;
import br.com.security.infra.security.TokenService;
import br.com.security.domain.user.AutheticationData;
import br.com.security.domain.user.Users;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AutheticationData data){
        System.out.println(data.email()+" - "+data.password());
        var token = new UsernamePasswordAuthenticationToken(data.email(), data.password());

        var authentication = manager.authenticate(token);

        var tokenJWT = tokenService.generateToken((Users) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));

    }



}
