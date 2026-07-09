package com.example.api_gateway.commondtos;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductionOrdersDto {

    private String orderNumber;
    //foreignkey--manufacturing plant
    private Long manufacturingPlant;
    //foreignkey-car model
    private Long carModel;
    @Enumerated(EnumType.STRING)
    private String status;
    @NotNull
    @Column(nullable = false)
    @Min(1)
    private Integer targetQuantity;
    @Min(0)
    private Integer completedQuantity;
    private LocalDate expectedEndDate;
    private LocalDate actualEndDate;
    private LocalDate createdAt;
    private Long createdBy;
    private LocalDate lastModifiedAt;
    private Long lastModifiedBy;
}
