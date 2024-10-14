package br.com.bernardo.projeto_integrador_ii.repository;

import br.com.bernardo.projeto_integrador_ii.entity.Like;
import br.com.bernardo.projeto_integrador_ii.entity.Post;
import br.com.bernardo.projeto_integrador_ii.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Integer> {

    Optional<Like> findByUserAndPost(User user, Post post);
    int countByPost(Post post);
}
