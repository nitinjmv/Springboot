package com.jmv.airlines.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "airlines")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;        // fixed
    private String country;     // fixed

    @Lob
    @Column(name = "custom_fields", columnDefinition = "text")
    private String customFields;
}
