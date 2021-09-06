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
public interface ReactiveStreamsUserRepo extends ReactiveStreamsCrudRepository<User,Integer> {

    Flux<User> findByNameContains(String name);  // Flux is correct type here
    Publisher<User> findByIdBetween(Integer id, Integer id2);
    Mono<User> findFirstBySurnameStartsWith(String surname);
}
