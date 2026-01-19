package com.jmv.airlines.api;

import com.jmv.airlines.domain.Airline;
import com.jmv.airlines.dto.AirlineRequest;
import com.jmv.airlines.dto.AirlineResponse;
import com.jmv.airlines.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/airlines")
@RequiredArgsConstructor
public class AirlineController {

    private final AirlineService service;
    private final ObjectMapper mapper;

    @PostMapping
    public AirlineResponse create(@RequestBody AirlineRequest request) {
        Airline airline = service.create(request);
        return toResponse(airline);
    }

    @GetMapping
    public List<AirlineResponse> list() {
        return service.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    private AirlineResponse toResponse(Airline airline) {
        AirlineResponse r = new AirlineResponse();
        r.setId(airline.getId());
        r.setName(airline.getName());
        r.setCountry(airline.getCountry());
        r.setCustomFields(readJson(airline.getCustomFields()));
        return r;
    }

    private Map<String, Object> readJson(String json) {
        try {
            return mapper.readValue(json, Map.class);
        } catch (Exception e) {
            return Map.of();
        }
    }
}
