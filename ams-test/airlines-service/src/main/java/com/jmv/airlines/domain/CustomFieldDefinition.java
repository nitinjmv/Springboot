package com.jmv.airlines.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "custom_field_definitions")
public class CustomFieldDefinition {

    @Id
    @GeneratedValue
    private Long id;

    private String entityType;
    private String fieldName;
    private String fieldType;
    private boolean required;
    private String errorMessage;

    @Column(columnDefinition = "text")
    private String rules;
}
