package com.example.APIgateway.commondtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturingPlantDto {
    private String name;
    private String code;
    private String location;
    @Min(1)
    private int capacity_per_day;
    @ColumnDefault("true")
    private boolean is_active;
    @NotNull
    private LocalDateTime created_at;
    @NotNull
    private Long created_by;
    @NotNull
    private LocalDateTime last_modified_at;
    @NotNull
    private Long last_modified_by;
}
