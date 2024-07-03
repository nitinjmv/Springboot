package com.example.sbswagger.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
In order to use builder & NoArgConstructor together
With builder pattern you want to restrict visibility of the constructor and mutators (setters) methods.
 To achieve this we set the visibility to package private via the access attribute on the
 @NoArgsConstructor and @AllArgsConstructor annotations and the value attribute on the @Setter annotation.
*/
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private double price;
}
