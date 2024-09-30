package br.com.bernardo.projeto_integrador_ii.service;

import br.com.bernardo.projeto_integrador_ii.entity.Comment;
import br.com.bernardo.projeto_integrador_ii.entity.Post;
import br.com.bernardo.projeto_integrador_ii.entity.User;
import br.com.bernardo.projeto_integrador_ii.repository.CommentRepository;
import br.com.bernardo.projeto_integrador_ii.repository.PostRepository;
import br.com.bernardo.projeto_integrador_ii.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Comment addComment(Long postId, Long userId, Comment comment) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        comment.setPost(post);
        comment.setUser(user);
        comment.setCreatedAt(new Date());
        return commentRepository.save(comment);
    }

}

