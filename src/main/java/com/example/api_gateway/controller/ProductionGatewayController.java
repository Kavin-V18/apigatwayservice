package com.example.api_gateway.controller;

import com.example.api_gateway.client.ProductionClient;
import com.example.api_gateway.commondtos.ProductionOrdersDto;
import com.example.api_gateway.responsedtos.ProductionOrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class ProductionGatewayController {
    private final ProductionClient productionClient;

    @GetMapping()
    public List<ProductionOrdersDto> getProductionOrders() {
        return productionClient.getAllOrders();
    }
    @GetMapping("/{id}")
    public ProductionOrderResponse getOrderById(@PathVariable int id){
        return productionClient.getOrderById(id);
    }
    @PostMapping()
    public String createOrder(@Valid @RequestBody ProductionOrdersDto supplierDto){
        productionClient.createOrder(supplierDto);
        return "order created successfully";
    }
    @PutMapping("/{id}")
    public ProductionOrdersDto updateOrder(@PathVariable int id,@Valid  @RequestBody ProductionOrdersDto productionOrdersDto){
        return  productionClient.updateOrderById(id,productionOrdersDto);
    }
    @DeleteMapping("/{id}")
    public  String deleteOrder(@PathVariable int id){
        productionClient.deleteOrder(id);
        return "order deleted Successfully";
    }
}
