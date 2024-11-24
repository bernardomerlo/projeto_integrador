package br.com.bernardo.projeto_integrador_ii.controller;

import br.com.bernardo.projeto_integrador_ii.entity.Comment;
import br.com.bernardo.projeto_integrador_ii.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{postId}/{userId}")
    public void postComment(@PathVariable Long postId ,@PathVariable Long userId, @RequestBody Comment comment) {
        this.commentService.addComment(postId, userId, comment);
    }

    @GetMapping("/{postId}")
    public long getCommentCount(@PathVariable Long postId) {
        return this.commentService.getCommentCountByPostId(postId);
    }

}
