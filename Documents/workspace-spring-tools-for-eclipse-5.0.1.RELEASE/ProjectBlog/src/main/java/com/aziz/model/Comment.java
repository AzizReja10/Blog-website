package com.aziz.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="comments")
public class Comment {
@Id
private String id;
private String postId;
private String author;
private String content;
private LocalDateTime createdAt=LocalDateTime.now();
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPostId() {
	return postId;
}
public void setPostId(String postId) {
	this.postId = postId;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public LocalDateTime getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
}

}
