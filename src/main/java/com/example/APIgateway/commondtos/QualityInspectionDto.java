package com.example.APIgateway.commondtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
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

    private String inspection_number;
    //foreign key-production order
    private Long production_order;
    //foreign key-employee
    @NotBlank
    private Long inspector;
    @Enumerated(EnumType.STRING)
    private String inspection_result;
    private String remarks;
    private LocalDateTime inspected_at;
    @NotBlank
    private LocalDateTime created_at;
    @NotBlank
    private String created_by;
    @NotBlank
    private LocalDateTime last_modified_at;
    @NotBlank
    private String last_modified_by;
}
