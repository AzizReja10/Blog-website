package com.aziz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aziz.model.Post;
import com.aziz.repository.PostRepository;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins="*")
public class PostController {
@Autowired
PostRepository postRepo;
@GetMapping
public List<Post> getAllPosts()
{
	return postRepo.findAll();
}
@GetMapping("{id}")
public Post getMethodName(@PathVariable String id) {
    return postRepo.findById(id).orElse(null);
}
@PostMapping
public Post createPost(@RequestBody Post post)
{
	return postRepo.save(post);
}
@PutMapping("/{id}")
public Post updatePost(@PathVariable String id,@RequestBody Post post)
{
	post.setId(id);
	return postRepo.save(post);
}
@DeleteMapping("/{id}")
public String deletePost(@PathVariable String id)
{
	postRepo.deleteById(id);
	return "post is deleted";

}
@GetMapping("/search")
public List<Post> searchPost(@RequestParam String text)
{
	return postRepo.findByTitleContainingIgnoreCase(text);
}
@GetMapping("/tag/{tag}")
public List<Post> getByTag(@PathVariable String tag) {
    return postRepo.findByTags(tag);
}

@GetMapping("/author/{author}")
public List<Post> getByAuthor(@PathVariable String author) {
    return postRepo.findByAuthor(author);
}
}
