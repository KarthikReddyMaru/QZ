package com.qz.userservice.model;

import com.qz.userservice.audit.AuditAwareImpl;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners({AuditAwareImpl.class, AuditingEntityListener.class})
public abstract class Auditable {

    @Column(updatable = false, nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(updatable = false, nullable = false)
    @CreatedBy
    private String createdBy;

    @Column(insertable = false)
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;

    @Column(insertable = false)
    @LastModifiedBy
    private String lastModifiedBy;
}
