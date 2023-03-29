package br.com.security.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("commitment")
public class commitment {
    private Long id;
    private String description;
    private DateTimeFormat dateCommitmentInitial;
    private DateTimeFormat dateCommitmentFinal;

    @PostMapping
    public String registerCommitment(){
        return "Cadastro de compromissos";
    }
}
