package com.mytests.micronaut.controllers;

import com.mytests.micronaut.data.User;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import reactor.core.publisher.Flux;

/**
 * *
 * <p>Created by irina on 9/6/2021.</p>
 * <p>Project: micronaut-r2dbc-reactor</p>
 * *
 */
@Client("http://localhost:8080/allUsers")
public interface UserClient {

    @Get
    Flux<User> getAll();
}
