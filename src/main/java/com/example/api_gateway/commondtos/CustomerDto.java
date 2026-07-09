package com.example.api_gateway.commondtos;


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
    private String customerName;
    @NotNull
    private String contactNumber;
    @Email(message = "Provide a Valid Email")
    @NotNull
    private String email;
    @NotNull
    private String address;
    @ColumnDefault("true")
    private boolean active;
    private Long createdBy;
    private Long lastModifiedBy;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
}
