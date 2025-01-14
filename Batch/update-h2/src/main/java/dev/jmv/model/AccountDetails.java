package dev.jmv.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long account_id;

    private String account_number;

    private String account_owner;
}
