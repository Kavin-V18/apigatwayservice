package com.example.APIgateway.commondtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDeliveryDto {

    @NotBlank
    private String invoiceNumber;
    @NotBlank
    //foreign key--vehicleInventory
    private Long vehicleId;
    @NotBlank
    //foreign-key --customer
    private Long customerId;
    @NotNull
    @PastOrPresent(message =
            "Delivery date cannot be in the future")
    private LocalDate deliveryDate;
    @NotNull
    @DecimalMin(value = "0.01",
            message = "Invoice amount must be greater than 0")
    private BigDecimal invoiceAmount;
    // FK -- Employee
    private Long deliveredByEmployeeId;
    @NotBlank
    private LocalDateTime created_at;

    private Long created_by;
    private LocalDateTime last_modified_at;
    private Long last_modified_by;
}
