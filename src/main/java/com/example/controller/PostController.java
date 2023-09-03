package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Post;
import com.example.service.PostService;

@RestController
@RequestMapping("v1/users")
public class PostController {
	@Autowired
	PostService service;
		
	@PostMapping
	public Post createPost(@RequestBody Post post) {
		return service.createPost(post);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Map<String, String>> updatePost(@RequestBody Post post) {
		service.updatePost(post);
		//send json response
		 Map<String, String> response = new HashMap<>();
	        response.put("message", "Updated successfully");
	        return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public Post getPostById(@PathVariable("id") Integer id) {
		return service.fetchPost(id);
	}
	
	@DeleteMapping(("/{id}"))
	public ResponseEntity<Map<String, String>> deletePost(@PathVariable("id") Integer id) {
		service.deletePost(id);
		//send json response
		 Map<String, String> response = new HashMap<>();
	        response.put("message", "Delete Successfully");
	        return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public List<Post> getAllPost() {
		return service.getAllPost();
	}
}
