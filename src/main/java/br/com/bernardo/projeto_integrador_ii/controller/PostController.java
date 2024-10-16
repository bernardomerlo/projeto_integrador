package br.com.bernardo.projeto_integrador_ii.controller;

import br.com.bernardo.projeto_integrador_ii.entity.Post;
import br.com.bernardo.projeto_integrador_ii.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/user/{userId}")
    public Post createPost(@PathVariable Long userId, @RequestBody Post post) {
        return postService.createPost(userId, post);
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/{postId}/like/user/{userId}")
    public void likePost(@PathVariable Long postId, @PathVariable Long userId) {
        postService.likePost(userId, postId);
    }

    @DeleteMapping("/{postId}/like/user/{userId}")
    public void deletePost(@PathVariable Long postId, @PathVariable Long userId) {
        postService.unlikePost(userId, postId);
    }

    @GetMapping("/{postId}/likes/count")
    public int getLikeCount(@PathVariable Long postId) {
        return postService.getLikesCount(postId);
    }
}