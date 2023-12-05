package com.example.clientcrud.controllers;


import com.example.clientcrud.models.Client;
import com.example.clientcrud.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> listar(){
        return clientRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //Quando cadastrar é retornado o código 201 de Created
    public Client adicionar(@RequestBody Client client){
        return clientRepository.save(client);
    }

}
