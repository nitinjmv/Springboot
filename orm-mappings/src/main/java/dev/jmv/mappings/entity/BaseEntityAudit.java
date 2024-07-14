package dev.jmv.mappings.entity;

import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity {

    @CreationTimestamp
    private Timestamp createdOn;

    @UpdateTimestamp
    private Timestamp updatedOn;

    @LastModifiedDate
    private Date lastModifiedDate;
    @LastModifiedBy
    private String modifiedBy;

    @CreatedBy
    private String createdBy;
}
