package com.mytests.micronaut.data;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.GeneratedValue;
/**
 * *
 * <p>Created by irina on 9/2/2021.</p>
 * <p>Project: micronaut-r2dbc-reactor</p>
 * *
 */
@MappedEntity("users")
public class User {

   @Id @GeneratedValue
   private Integer id;
   private String name;
   private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

   public User(){}

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
