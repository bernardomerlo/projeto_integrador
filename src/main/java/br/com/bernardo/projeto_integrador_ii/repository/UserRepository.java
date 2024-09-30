package br.com.bernardo.projeto_integrador_ii.repository;

import br.com.bernardo.projeto_integrador_ii.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
