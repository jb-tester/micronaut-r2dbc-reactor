package com.mytests.micronaut.controllers;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.reactor.http.client.ReactorHttpClient;
import jakarta.inject.Inject;
import reactor.core.publisher.Flux;

/**
 * *
 * <p>Created by irina on 9/6/2021.</p>
 * <p>Project: micronaut-r2dbc-reactor</p>
 * *
 */
@Controller
public class ClientController {

    @Inject @Client("http://localhost:8080/allUsers")
    ReactorHttpClient client;

    @Get("test")
    Flux<String> testAll(){
        return client.retrieve(HttpRequest.GET("/"));
    }
}
