package com.qz.userservice.model;

import com.qz.userservice.audit.AuditAwareImpl;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditAwareImpl.class)
public abstract class Auditable {

    @Column(updatable = false, nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(updatable = false, nullable = false)
    @CreatedBy
    private String createdBy;

    @Column(insertable = false, nullable = false)
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;

    @Column(insertable = false, nullable = false)
    @LastModifiedBy
    private String lastModifiedBy;
}
