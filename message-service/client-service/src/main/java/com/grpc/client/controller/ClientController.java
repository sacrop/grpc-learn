package com.grpc.client.controller;

import com.grpc.client.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping("/user/{message}")
    public String requestPing(@PathVariable String message){
        return clientService.pongRequest(message);
    }
}
