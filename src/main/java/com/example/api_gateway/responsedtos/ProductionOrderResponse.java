package com.example.api_gateway.responsedtos;


import com.example.api_gateway.commondtos.CarModelDto;
import com.example.api_gateway.commondtos.ManufacturingPlantDto;
import com.example.api_gateway.commondtos.ProductionOrdersDto;
import lombok.Data;
@Data
public class ProductionOrderResponse {
    private ProductionOrdersDto productionOrder;
    private ManufacturingPlantDto manufacturingPlant;
    private CarModelDto carModel;
}
