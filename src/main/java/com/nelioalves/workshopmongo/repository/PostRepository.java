package com.nelioalves.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.workshopmongo.domain.Post;

@Repository 
public interface PostRepository extends MongoRepository<Post, String> { // O primeiro espaço é oq vai gerenciar e o segundo espaço o tipo do ID
    

    List<Post> findByTitleContainingIgnoreCase(String text);
}
