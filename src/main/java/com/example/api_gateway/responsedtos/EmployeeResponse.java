package com.example.api_gateway.responsedtos;

import com.example.api_gateway.commondtos.EmployeeDto;
import com.example.api_gateway.commondtos.ManufacturingPlantDto;
import lombok.Data;
@Data
public class EmployeeResponse {
    private EmployeeDto employee;
    private ManufacturingPlantDto manufacturingPlant;
}
