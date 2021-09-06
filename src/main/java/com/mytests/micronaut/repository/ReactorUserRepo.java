package com.mytests.micronaut.repository;

import com.mytests.micronaut.data.User;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.r2dbc.repository.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * *
 * <p>Created by irina on 9/2/2021.</p>
 * <p>Project: micronaut-r2dbc-reactor</p>
 * *
 */
@R2dbcRepository(dialectName = "H2")
public interface ReactorUserRepo extends ReactorCrudRepository<User,Integer> {

    Flux<User> findByNameContainsAndSurnameContains(String name, String surname);
    Publisher<String> findNameBySurnameContains(String surname);
    Mono<User> findTopByNameOrName(String name, String name2);
}
