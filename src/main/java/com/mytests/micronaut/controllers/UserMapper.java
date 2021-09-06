package com.mytests.micronaut.controllers;

import com.mytests.micronaut.data.User;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

/**
 * *
 * <p>Created by irina on 9/6/2021.</p>
 * <p>Project: micronaut-r2dbc-reactor</p>
 * *
 */
@Singleton
public class UserMapper {

    public Flux<String> userToString(User user) {
        return Flux.just(user.toString());
    }
}
