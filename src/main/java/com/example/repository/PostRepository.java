package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer>{
	
}
