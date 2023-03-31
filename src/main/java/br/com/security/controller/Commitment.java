package br.com.security.controller;

import br.com.security.domain.user.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/commitment")
public class Commitment {
    private Long id;
    private String description;
    private DateTimeFormat dateCommitmentInitial;
    private DateTimeFormat dateCommitmentFinal;

    @Autowired
    private UsersRepository repository;
    @GetMapping
    public String registerCommitment(){
        return "Compromissos";

    }
}
