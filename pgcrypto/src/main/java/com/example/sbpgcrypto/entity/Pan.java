package com.example.sbpgcrypto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PAN_TABLE")
public class Pan {

    @Id
    @Column(name = "PAN_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAN_SEQUENCE")
    @SequenceGenerator(name = "PAN_SEQUENCE", sequenceName = "PAN_SEQUENCE", allocationSize = 1)
    private Long id;

    @ColumnTransformer(
            forColumn = "PAN_NUMBER",
            read = "pgp_sym_decrypt(PAN_NUMBER::bytea, '${pgcrypto.secret}')",
            write = "pgp_sym_encrypt(?, '${pgcrypto.secret}')"
    )
    @Column(name = "PAN_NUMBER", updatable = false)
    private byte[] number;

    @Column(name = "PAN_TYPE")
    private String type;

    @Column(name = "CREATED_DATE", updatable = false, columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private Instant createdDate;

    @Column(name = "STS")
    private String status;

}
