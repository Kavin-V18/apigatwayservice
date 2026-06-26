package com.example.APIgateway.commondtos;

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
    private String model_name;
    private String fuelType;
    private String transmission;
    private double base_price;
    private List<String> color_options;
    private LocalDate launch_date;
    @ColumnDefault("true")
    private boolean is_active;
    private LocalDateTime created_at;
    private String created_by;
    private LocalDateTime last_modified_at;
    private String last_modified_by;
}
