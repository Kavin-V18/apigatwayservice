package com.example.api_gateway.commondtos;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceHistoryDto {
    //foreign key--vehicle inventory
    private Long vehicle;
    @NotBlank
    @Column(nullable = false)
    private LocalDate serviceDate;
    @NotBlank
    @Column(nullable = false)
    private String serviceCenter;
    @Enumerated(EnumType.STRING)
    private String serviceType;
    @NotBlank
    @Column(nullable = false)
    @Min((1))
    private double cost;
    private String remarks;
    private LocalDate createdAt;
    private Long createdBy;
    private LocalDateTime lastModifiedAt;
    private Long lastModifiedBy;
}
