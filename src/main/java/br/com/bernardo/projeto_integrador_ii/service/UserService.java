package br.com.bernardo.projeto_integrador_ii.service;

import br.com.bernardo.projeto_integrador_ii.entity.User;
import br.com.bernardo.projeto_integrador_ii.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Injeção de dependência via construtor
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        // Em um cenário real, você deve criptografar a senha
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Métodos adicionais como findByUsername etc.

}
