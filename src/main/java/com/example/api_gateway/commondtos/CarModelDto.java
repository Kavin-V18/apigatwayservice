package com.example.api_gateway.commondtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarModelDto {
    @NotNull
    private String modelName;
    private String fuelType;
    private String transmission;
    private double basePrice;
    private List<String> colorOptions;
    private LocalDate launchDate;
    @ColumnDefault("true")
    private Boolean active;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime lastModifiedAt;
    private Long lastModifiedBy;
}
