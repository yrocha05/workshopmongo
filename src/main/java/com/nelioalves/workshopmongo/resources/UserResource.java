package com.nelioalves.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.services.UserService;

@RestController // Controlador Rest
@RequestMapping(value = "/users") // Adiciona no valor / Users na API 
public class UserResource {

    @Autowired // Enjeta a camada service no Controlador Rest
    private UserService service;
    
    @RequestMapping(method = RequestMethod.GET) // Busca no banco de Dados e guarda na Lista e devolve a lista na resposta da requisição 
    public ResponseEntity<List<UserDTO>>  findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); // Converte uma Lista em outra de outro tipo
        return ResponseEntity.ok().body(listDto);
    }
}
