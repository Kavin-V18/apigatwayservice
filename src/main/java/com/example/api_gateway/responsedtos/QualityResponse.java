package com.example.api_gateway.responsedtos;

import com.example.api_gateway.commondtos.QualityInspectionDto;
import lombok.Data;

@Data
public class QualityResponse {

     private ProductionOrderResponse productionOrder;
     private QualityInspectionDto quality;
     private EmployeeResponse employee;
}
