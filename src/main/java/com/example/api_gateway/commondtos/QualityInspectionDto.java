package com.example.api_gateway.commondtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QualityInspectionDto {
    private String inspectionNumber;
    //foreign key-production order
    private Long productionOrder;
    //foreign key-employee
    private Long inspector;
    @Enumerated(EnumType.STRING)
    private String inspectionResult;
    private String remarks;
    private LocalDateTime inspectedAt;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime lastModifiedAt;
    private Long lastModifiedBy;
}
