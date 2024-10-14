package br.com.bernardo.projeto_integrador_ii.service;

import br.com.bernardo.projeto_integrador_ii.entity.Like;
import br.com.bernardo.projeto_integrador_ii.entity.Post;
import br.com.bernardo.projeto_integrador_ii.entity.User;
import br.com.bernardo.projeto_integrador_ii.repository.LikeRepository;
import br.com.bernardo.projeto_integrador_ii.repository.PostRepository;
import br.com.bernardo.projeto_integrador_ii.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository, LikeRepository likeRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.likeRepository = likeRepository;
    }

    public Post createPost(Long userId, Post post) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        post.setUser(user);
        post.setCreatedAt(new Date());
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void likePost(Long userId, Long postId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário nao encontrado!"));
        Post post = postRepository.findById(postId).orElse(null);
        if(likeRepository.findByUserAndPost(user, post).isPresent()) {
            throw new RuntimeException("Vc ja curtiu essa bufufa mane");
        }
        Like like = new Like(user, post);
        likeRepository.save(like);
    }

    public void unlikePost(Long userId, Long postId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário nao encontrado!"));
        Post post = postRepository.findById(postId).orElse(null);
        Like like = likeRepository.findByUserAndPost(user, post).orElseThrow(() -> new RuntimeException("Você não curtiu este post"));
        likeRepository.delete(like);
    }

    public int getLikesCount(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("num existe esse post"));
        return likeRepository.countByPost(post);
    }
}
