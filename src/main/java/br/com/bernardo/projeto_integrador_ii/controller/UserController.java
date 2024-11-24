package br.com.bernardo.projeto_integrador_ii.controller;

import br.com.bernardo.projeto_integrador_ii.entity.User;
import br.com.bernardo.projeto_integrador_ii.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("sucesso!");
    }

    @GetMapping( "/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.findById(id);
    }
}
