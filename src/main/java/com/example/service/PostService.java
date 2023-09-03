package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Post;
import com.example.repository.PostRepository;

@Service
public class PostService {
	@Autowired(required=true)
	PostRepository repository;
	
	public Post createPost(Post post) {
		return repository.save(post);
	}
	
	public void updatePost(Post post) {
		Optional<Post> postop =  repository.findById(post.getId());
		if(postop.isPresent()) {
			Post postFromDb = postop.get();
			postFromDb.setDescription(post.getDescription());
			postFromDb.setName(post.getName());
			postFromDb.setEmail(post.getEmail());
			postFromDb.setContactNo(post.getContactNo());
			postFromDb.setStatus(post.getStatus());
			repository.save(postFromDb);
		}	
	}
	
	public void deletePost(Integer id) {
		repository.deleteById(id);
	}
	
	public Post fetchPost(Integer id) {
		return repository.findById(id).get();
	}
	
	public List<Post> getAllPost() {
		return repository.findAll();
	}
	
}
