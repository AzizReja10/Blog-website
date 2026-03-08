package com.aziz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aziz.model.Comment;
import java.util.*;
public interface CommentRepository extends MongoRepository<Comment,String> {
List<Comment> findByPostId(String postId);
}
