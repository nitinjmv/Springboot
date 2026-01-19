package com.jmv.airlines.api;


import com.jmv.airlines.domain.CustomFieldDefinition;
import com.jmv.airlines.dto.CustomFieldDefinitionRequest;
import com.jmv.airlines.dto.CustomFieldDefinitionResponse;
import com.jmv.airlines.service.CustomFieldDefinitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/custom-fields")
@RequiredArgsConstructor
public class CustomFieldDefinitionController {

    private final CustomFieldDefinitionService service;

    // ✅ CREATE
    @PostMapping
    public CustomFieldDefinitionResponse create(
            @RequestBody CustomFieldDefinitionRequest request) {

        CustomFieldDefinition saved = service.create(request);
        return toResponse(saved);
    }

    // ✅ READ (by entity type)
    @GetMapping
    public List<CustomFieldDefinitionResponse> getByEntityType(
            @RequestParam String entityType) {

        return service.findByEntityType(entityType)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private CustomFieldDefinitionResponse toResponse(CustomFieldDefinition def) {
        CustomFieldDefinitionResponse r = new CustomFieldDefinitionResponse();
        r.setId(def.getId());
        r.setEntityType(def.getEntityType());
        r.setFieldName(def.getFieldName());
        r.setFieldType(def.getFieldType());
        r.setRequired(def.isRequired());
        r.setRules(def.getRules());
        return r;
    }
}
