package dev.jmv.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "ACCOUNT_DETAILS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String account_number;

    private String account_owner;
}
