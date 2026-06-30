package com.example.APIgateway.commondtos;

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
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductionOrdersDto {

    private String order_number;
    //foreignkey--manufacturing plant
    private Long manufacturingPlant;
    //foreignkey-car model
    private Long carModel;
    @Enumerated(EnumType.STRING)
    private String status;
    @NotNull
    @Column(nullable = false)
    @Min(1)
    private int target_quantity;
    @Min(0)
    private int completed_quantity;
    private LocalDate expected_end_date;
    private LocalDate actual_end_date;
    private LocalDateTime created_at;
    private Long created_by;
    private LocalDateTime last_modified_at;
    private Long last_modified_by;
}
