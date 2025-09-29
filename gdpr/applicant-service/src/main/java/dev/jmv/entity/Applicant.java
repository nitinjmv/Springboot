package dev.jmv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "applicant")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Applicant {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Timestamp timestamp;
    private String name;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApplicantEvent> applicantEvents;
}
