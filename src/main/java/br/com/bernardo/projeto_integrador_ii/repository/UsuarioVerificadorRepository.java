package br.com.bernardo.projeto_integrador_ii.repository;

import java.util.Optional;
import java.util.UUID;

import br.com.bernardo.projeto_integrador_ii.entity.UsuarioVerificadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuarioVerificadorRepository extends JpaRepository<UsuarioVerificadorEntity, Long>{

	public Optional<UsuarioVerificadorEntity> findByUuid(UUID uuid);
}
