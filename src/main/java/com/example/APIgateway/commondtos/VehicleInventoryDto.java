package com.example.APIgateway.commondtos;

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
    @NotBlank
    //foreign key-producton order
    private Long production_orders;
    @NotBlank
    //foreign key-carModel
    private long carModel;
    @NotBlank
    private String color;
    @Enumerated(EnumType.STRING)
    private String status;
    @NotBlank
    private LocalDate manufactured_date;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime last_modified_at;
    private Long created_by;
    private Long last_modified_by;
}
