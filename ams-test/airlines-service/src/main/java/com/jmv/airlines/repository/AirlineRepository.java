package com.jmv.airlines.repository;

import com.jmv.airlines.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AirlineRepository extends JpaRepository<Airline, UUID> {}
