package com.example.api_gateway.commondtos;

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

    private String employeeCode;
    @NotNull
    private String fullName;
    @NotNull
    private String designation;
    private LocalDate dateOfBirth;
    private LocalDate joiningDate;
    //image
//    @Lob
//    @Column(columnDefinition = "LONGBLOB")
    private String profileImage;
    @ColumnDefault("true")
    private  boolean active;
    //foreign key for plant //need to map
    private Long manufacturingPlant;
    private LocalDate createdAt;
    private LocalDate lastModifiedAt;
    private Long createdBy;
    private Long lastModifiedBy;
}
