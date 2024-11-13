package br.com.bernardo.projeto_integrador_ii.service;

import br.com.bernardo.projeto_integrador_ii.entity.Post;
import br.com.bernardo.projeto_integrador_ii.entity.User;

import br.com.bernardo.projeto_integrador_ii.repositories.PostRepository;
import br.com.bernardo.projeto_integrador_ii.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // Injeção de dependência via construtor
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Post createPost(Long userId, Post post) {
        User user = userRepository.findById(String.valueOf(userId))
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        post.setUser(user);
        post.setCreatedAt(new Date());
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
