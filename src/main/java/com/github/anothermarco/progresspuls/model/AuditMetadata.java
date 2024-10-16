package com.github.anothermarco.progresspuls.model;

import com.github.anothermarco.progresspuls.constants.DatabaseConstants.Audit;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Getter
@Setter
@ToString
@Embeddable
public class AuditMetadata {

    @CreatedBy
    @Column(name = Audit.COLUMN_CREATED_BY)
    private String createdBy;

    @LastModifiedBy
    @Column(name = Audit.COLUMN_LAST_MODIFIED_BY)
    private String lastModifiedBy;

    @CreatedDate
    @Column(name = Audit.COLUMN_CREATED_DATE)
    private Instant createdDate;

    @LastModifiedDate
    @Column(name = Audit.COLUMN_LAST_MODIFIED_DATE)
    private Instant lastModifiedDate;
}
