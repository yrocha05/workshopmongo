package com.nelioalves.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.resources.util.URL;
import com.nelioalves.workshopmongo.services.PostService;

@RestController // Controlador Rest
@RequestMapping(value = "/posts") // Adiciona no valor / Posts na API 
public class PostResource {

    @Autowired // Enjeta a camada service no Controlador Rest
    private PostService service;
    
    @RequestMapping(method = RequestMethod.GET) // Busca no banco de Dados e guarda na Lista e devolve a lista na resposta da requisição 
    public ResponseEntity<List<Post>>  findAll(){
        List<Post> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value ="/{id}" , method = RequestMethod.GET) // Busca no banco de Dados e guarda na Lista e devolve a lista na resposta da requisição 
    public ResponseEntity<Post>  findByID(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value ="/titlesearch" , method = RequestMethod.GET) // Busca no banco de Dados e guarda na Lista e devolve a lista na resposta da requisição 
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text){
        text = URL.decodeParam(text);    
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }



}
