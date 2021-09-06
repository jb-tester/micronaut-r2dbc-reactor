package com.mytests.micronaut.controllers;

import com.mytests.micronaut.SetupService;
import com.mytests.micronaut.data.User;
import com.mytests.micronaut.repository.ReactiveStreamsUserRepo;
import com.mytests.micronaut.repository.ReactorUserRepo;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * *
 * <p>Created by irina on 9/2/2021.</p>
 * <p>Project: micronaut-r2dbc-reactor</p>
 * *
 */
@Controller
public class UserController {

    @Inject
    ReactiveStreamsUserRepo reactiveStreamsRepo;
    @Inject
    ReactorUserRepo reactRepo;
    @Inject
    SetupService service;
    @Inject
    private UserMapper userMapper;

    @Post("/")
    public void setup(){
        service.setUpDb().block();
    }
    // reactiveStreams repo:
    @Get("/allUsers")
    public Flux<String> allUsers() {
        return Flux.from(reactiveStreamsRepo.findAll()).flatMap(userMapper::userToString);
    }
    @Get("/usersByName/{name}")
    public Flux<User> byName(@PathVariable String name){
        return reactiveStreamsRepo.findByNameContains(name);
    }

    @Get("/userBySurname/{lastname}")
    public Mono<User> userBySurnameStartingWith(@PathVariable String lastname) {
        return reactiveStreamsRepo.findFirstBySurnameStartsWith(lastname);
    }

    @Get("/byIds/{i1}/{i2}")
    public Flux<User> byIds(@PathVariable String i1, @PathVariable String i2) {
        return Flux.from(reactiveStreamsRepo.findByIdBetween(Integer.parseInt(i1),Integer.parseInt(i2)));
    }
 // reactor repo:
    @Get("/usersByNameAndSurname/{n1}/{n2}")
    public Flux<User> usersByNameAndSurname(@PathVariable String n1, @PathVariable String n2) {
        return reactRepo.findByNameContainsAndSurnameContains(n1,n2);
    }

    @Get("/userByOneOfNames/{n1}/{n2}")
    public Mono<User> userByOneOfNames(@PathVariable String n1, @PathVariable String n2) {
        return reactRepo.findTopByNameOrName(n1,n2);
    }

    @Get("/firstNameBySurname/{name}")
    public Mono<String> firstNameBySurname(@PathVariable String name) {
        return Mono.from(reactRepo.findNameBySurnameContains(name));
    }
}
