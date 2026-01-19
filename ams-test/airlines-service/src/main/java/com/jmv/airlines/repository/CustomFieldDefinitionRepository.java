package com.jmv.airlines.repository;

import com.jmv.airlines.domain.CustomFieldDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomFieldDefinitionRepository
        extends JpaRepository<CustomFieldDefinition, Long> {

    List<CustomFieldDefinition> findByEntityType(String entityType);
}
