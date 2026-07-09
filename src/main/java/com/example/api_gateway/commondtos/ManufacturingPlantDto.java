package com.example.api_gateway.commondtos;

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
public class ManufacturingPlantDto {
    private String name;
    private String code;
    private String location;
    private Integer capacityPerDay;
    private Boolean active;
    @NotNull
    private LocalDate createdAt;
    @NotNull
    private Long createdBy;
    @NotNull
    private LocalDate lastModifiedAt;
    @NotNull
    private Long lastModifiedBy;
}
