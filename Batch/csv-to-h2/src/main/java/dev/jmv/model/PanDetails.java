package dev.jmv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Builder
public class PanDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pan_id;

    private String pan_number;

    private Date created_at;
}
