package br.com.bernardo.projeto_integrador_ii.repository;

import java.util.Optional;

import br.com.bernardo.projeto_integrador_ii.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

	Optional<UsuarioEntity> findByLogin(String login);
}
