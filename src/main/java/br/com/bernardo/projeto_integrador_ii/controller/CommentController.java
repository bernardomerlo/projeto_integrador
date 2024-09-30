package br.com.bernardo.projeto_integrador_ii.controller;
import br.com.bernardo.projeto_integrador_ii.entity.Comment;
import br.com.bernardo.projeto_integrador_ii.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/post/{postId}/user/{userId}")
    public Comment addComment(@PathVariable Long postId, @PathVariable Long userId, @RequestBody Comment comment) {
        return commentService.addComment(postId, userId, comment);
    }
}

