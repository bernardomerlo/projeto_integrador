package br.com.bernardo.projeto_integrador_ii.repository;

import br.com.bernardo.projeto_integrador_ii.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}