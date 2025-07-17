package com.jmv.controller;

import com.jmv.entity.Event;
import com.jmv.repository.EventRepository;
import com.jmv.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("event")
@RequiredArgsConstructor
public class EventController {

    private final EventRepository repository;

    @GetMapping
    public ResponseEntity<List<Event>> getEvents(){
        return ResponseEntity.ok(repository.findAll());
    }
}
