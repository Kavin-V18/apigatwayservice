package com.example.APIgateway.commondtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private String employee_code;
    @NotNull
    private String full_name;
    @NotNull
    private String designation;
    private LocalDate date_of_birth;
    private LocalDate joining_date;
    //image
//    @Lob
//    @Column(columnDefinition = "LONGBLOB")
//    private byte[] profile_image;
    @ColumnDefault("true")
    private  boolean is_active;
    //foreign key for plant //need to map
    private Long manufacturingPlant;
    private LocalDate created_at;
    private LocalDate last_modified_at;
    private String created_by;
    private String last_modified_by;
}
