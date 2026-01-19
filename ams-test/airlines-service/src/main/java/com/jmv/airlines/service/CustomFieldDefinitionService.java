package com.jmv.airlines.service;

import com.jmv.airlines.domain.CustomFieldDefinition;
import com.jmv.airlines.dto.CustomFieldDefinitionRequest;
import com.jmv.airlines.repository.CustomFieldDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomFieldDefinitionService {

    private final CustomFieldDefinitionRepository repository;

    public CustomFieldDefinition create(CustomFieldDefinitionRequest request) {

        CustomFieldDefinition def = new CustomFieldDefinition();
        def.setEntityType(request.getEntityType());
        def.setFieldName(request.getFieldName());
        def.setFieldType(request.getFieldType());
        def.setRequired(request.isRequired());
        def.setRules(request.getRules());

        return repository.save(def);
    }

    public List<CustomFieldDefinition> findByEntityType(String entityType) {
        return repository.findByEntityType(entityType);
    }
}
