package com.example.api_gateway.responsedtos;

import com.example.api_gateway.commondtos.CarModelDto;
import com.example.api_gateway.commondtos.VehicleInventoryDto;
import lombok.Data;

@Data
public class InventoryResponse {
    private ProductionOrderResponse productionOrders;
    private CarModelDto carModel;
    private VehicleInventoryDto vehicleInventory;
}
