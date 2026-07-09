package com.example.api_gateway.commondtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDto {
    @NotNull
    @Column(nullable = false)
    private String supplierName;
    @NotNull
    @Column(nullable = false,unique = true)
    private String supplierCode;
    @Email(message = "provide a valid Email")
    @NotNull
    @Column(nullable = false)
    private String contactEmail;
    @Min(1)
    @Max(5)
    private Integer rating;
    //have to add
    private String gstNumber;
    @ColumnDefault("true")
    private Boolean active;
    private LocalDate createdAt;
    private LocalDate lastModifiedAt;
    private Long createdBy;
    private Long lastModifiedBy;
}
