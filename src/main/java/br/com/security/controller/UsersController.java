package br.com.security.controller;

import br.com.security.domain.user.Users;
import br.com.security.domain.user.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UsersController {

    @Autowired
    private UsersRepository respository;

    @PostMapping("/register")
    private String RegisterUsers(  @RequestBody @Valid Users users){
        System.out.println("USERS"+users.getUsername()+" - " + users.getEmail());
        respository.save(users);
        return "Usuario cadastrado com sucesso! ";
    }

    @GetMapping("/users")
    private List<Users> ListUsers(){
        return respository.findAll();
    }

}
