package com.example.APIgateway.commondtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
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
    private String supplier_name;
    @NotNull
    @Column(nullable = false,unique = true)
    private String supplier_code;
    @Email(message = "provide a valid Email")
    @NotNull
    @Column(nullable = false)
    private String contact_email;
    @Max(5)
    private int rating;
    //have to add
    private String gst_number;
    @ColumnDefault("true")
    private boolean is_active;
    private LocalDate created_at;
    private LocalDate last_modified_at;
    private String Created_by;
    private String last_modified_by;
}
