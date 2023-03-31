package br.com.security.controller;

import br.com.security.domain.user.Users;
import br.com.security.domain.user.UsersRepository;
import br.com.security.infra.security.SecurityConfigurations;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UsersController {

    @Autowired
    private UsersRepository respository;
    @Autowired
    private SecurityConfigurations configurations;

    @PostMapping("/register")
    private String RegisterUsers(  @RequestBody @Valid Users users) {
        users.setPassword(configurations.passwordEncoder().encode(users.getPassword()));
        System.out.println("USERS"+users.getUsername()+" - " + users.getPassword());
        respository.save(users);

        return "Usuario cadastrado com sucesso!";
    }

    @GetMapping("/users")
    private List<Users> ListUsers(){
        return respository.findAll();
    }

}
