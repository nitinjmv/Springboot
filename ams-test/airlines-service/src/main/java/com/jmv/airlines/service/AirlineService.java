package com.jmv.airlines.service;

import com.jmv.airlines.domain.Airline;
import com.jmv.airlines.domain.CustomFieldDefinition;
import com.jmv.airlines.domain.RuleEvaluator;
import com.jmv.airlines.dto.AirlineRequest;
import com.jmv.airlines.repository.AirlineRepository;
import com.jmv.airlines.repository.CustomFieldDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AirlineService {

    private final AirlineRepository airlineRepository;
    private final CustomFieldDefinitionRepository fieldRepo;
    private final RuleEvaluator ruleEvaluator;
    private final ObjectMapper mapper;

    public Airline create(AirlineRequest request) {

        Map<String, Object> customFields = request.getCustomFields();
        List<CustomFieldDefinition> definitions =
                fieldRepo.findByEntityType("AIRLINE");

        for (CustomFieldDefinition def : definitions) {

            Object value = customFields.get(def.getFieldName());

            if (def.isRequired() && value == null) {
                throw new IllegalArgumentException(def.getFieldName() + " is required");
            }

            if (def.getRules() != null) {
                ruleEvaluator.evaluate(def, customFields);
            }
        }

        Airline airline = new Airline();
        airline.setName(request.getName());
        airline.setCountry(request.getCountry());
        airline.setCustomFields(writeJson(customFields));

        ObjectMapper mapper = new ObjectMapper();
        airline.setCustomFields(mapper.writeValueAsString(request.getCustomFields()));

        return airlineRepository.save(airline);
    }

    public List<Airline> findAll() {
        return airlineRepository.findAll();
    }

    private String writeJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
