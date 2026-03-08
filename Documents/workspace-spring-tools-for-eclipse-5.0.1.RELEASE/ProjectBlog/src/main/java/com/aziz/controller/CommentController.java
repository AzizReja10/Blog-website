package com.aziz.controller;

import com.aziz.model.Comment;
import com.aziz.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
public class CommentController {

    @Autowired
    CommentRepository commentRepo;

    @GetMapping("/{postId}")
    public List<Comment> getComments(@PathVariable String postId) {
        return commentRepo.findByPostId(postId);
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return commentRepo.save(comment);
    }

    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable String id) {
        commentRepo.deleteById(id);
        return "Comment deleted";
    }
}