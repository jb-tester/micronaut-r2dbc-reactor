package com.mytests.micronaut;

import com.mytests.micronaut.data.User;
import com.mytests.micronaut.repository.ReactiveStreamsUserRepo;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.Arrays;

/**
 * *
 * <p>Created by irina on 9/2/2021.</p>
 * <p>Project: micronaut-r2dbc-reactor</p>
 * *
 */
@Singleton
public class SetupService {

    private ReactiveStreamsUserRepo repo;

    public SetupService(ReactiveStreamsUserRepo repo) {
        this.repo = repo;
    }

    @Transactional
    public Mono<Void> setUpDb(){

        return Mono.from(repo.saveAll(Arrays.asList(
                new User("vasya","ivanov"),
                new User("vanya","petrov"),
                new User("petya","ivanov"),
                new User("petya","petrov"),
                new User("vasya","sidorov"),
                new User("masha","sidorova"),
                new User("lena","ivanova"),
                new User("valya","vanina"),
                new User("polina","pavlova"),
                new User("pasha","panin")
        ))).then();
    }
}
