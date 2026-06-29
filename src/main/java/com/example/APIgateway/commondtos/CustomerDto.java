package com.example.APIgateway.commondtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    @NotNull
    private String customer_name;
    @NotNull
    private String contact_number;
    @Email(message = "Provide a Valid Email")
    @NotNull
    private String email;
    @NotNull
    private String address;
    @ColumnDefault("true")
    private boolean is_active;
    private String created_by;
    private String last_modified_by;
    private LocalDateTime created_at;
    private LocalDateTime last_modified_at;
}
