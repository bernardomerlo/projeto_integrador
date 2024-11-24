package br.com.bernardo.projeto_integrador_ii.repositories;

import br.com.bernardo.projeto_integrador_ii.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT COUNT(c) FROM Comment c WHERE c.post.id = :postId")
    long countByPostId(Long postId);
}
