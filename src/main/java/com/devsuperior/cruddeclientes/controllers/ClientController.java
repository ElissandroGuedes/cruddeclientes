package com.devsuperior.cruddeclientes.controllers;

import com.devsuperior.cruddeclientes.entities.Client;
import com.devsuperior.cruddeclientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientRepository respository;

    @GetMapping
    public List<Client> findAll() {
        List<Client> result = respository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public Client findById(@PathVariable Long id) {
        Client result = respository.findById(id).get();
        return result;
    }

    @PostMapping
    public Client insert(@RequestBody Client client) {
        Client result = respository.save(client);
        return result;
    }

}

