package br.com.bernardo.projeto_integrador_ii.repositories;


import br.com.bernardo.projeto_integrador_ii.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
