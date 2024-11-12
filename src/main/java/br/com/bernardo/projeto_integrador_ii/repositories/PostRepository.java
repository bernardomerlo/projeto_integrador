package br.com.bernardo.projeto_integrador_ii.repositories;
import br.com.bernardo.projeto_integrador_ii.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

