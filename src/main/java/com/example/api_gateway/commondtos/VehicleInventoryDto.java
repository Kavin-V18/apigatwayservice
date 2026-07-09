package com.example.api_gateway.commondtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleInventoryDto {

    @NotBlank
    private String vin;
    //foreign key-producton order
    private Long productionOrders;
    //foreign key-carModel
    private Long carModel;
    @NotBlank
    private String color;
    @Enumerated(EnumType.STRING)
    private String status;
    private LocalDate manufacturedDate;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime lastModifiedAt;
    private Long createdBy;
    private Long lastModifiedBy;
}
