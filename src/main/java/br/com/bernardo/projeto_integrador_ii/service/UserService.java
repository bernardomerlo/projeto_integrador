package br.com.bernardo.projeto_integrador_ii.service;

import br.com.bernardo.projeto_integrador_ii.entity.User;
import br.com.bernardo.projeto_integrador_ii.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
