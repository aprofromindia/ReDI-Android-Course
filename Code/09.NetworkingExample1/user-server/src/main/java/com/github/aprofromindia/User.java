package com.github.aprofromindia;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Apro on 13-06-2017.
 */
@Entity
@Getter
@EqualsAndHashCode(of = "id")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String name;

    @Min(0)
    private int age;

    @NotNull
    private String subject;

    @PersistenceConstructor
    User() {}

    User(String name, int age, String subject) {
        this.name = name;
        this.age = age;
        this.subject = subject;
    }
}
