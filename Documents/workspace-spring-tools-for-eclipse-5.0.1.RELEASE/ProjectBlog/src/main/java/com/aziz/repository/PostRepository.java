package com.aziz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aziz.model.Post;
import java.util.*;
import java.util.List;

public interface PostRepository extends MongoRepository<Post,String> {
List<Post> findByAuthor(String author);
List<Post> findByTags(String tags);
List<Post> findByTitleContainingIgnoreCase(String title);
}
