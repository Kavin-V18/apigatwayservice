package com.example.APIgateway.controller;

import com.example.APIgateway.client.ProductionClient;
import com.example.ProductionModule.dto.ProductionOrdersDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders")
public class ProductionGatwayController {
    private final ProductionClient productionClient;
    public ProductionGatwayController(ProductionClient productionClient){
        this.productionClient=productionClient;
    }
    @GetMapping()
    public List<Optional> getProductionOrders() {
        return productionClient.getAllOrders();
    }
    @GetMapping("/{id}")
    public ProductionOrdersDto getOrderById(@PathVariable int id){
        return productionClient.getOrderById(id);
    }
    @PostMapping()
    public String createOrder(@Valid @RequestBody ProductionOrdersDto supplierDto){
        productionClient.createOrder(supplierDto);
        return "order created successfully";
    }
    @PostMapping("/{id}")
    public ProductionOrdersDto UpdateOrder(@PathVariable int id,@Valid  @RequestBody ProductionOrdersDto productionOrdersDto){
        return  productionClient.updateOrderById(id,productionOrdersDto);
    }
    @DeleteMapping("/{id}")
    public  String deleteOrder(@PathVariable int id){
        productionClient.deleteOrder(id);
        return "order deleted Successfully";
    }
}
