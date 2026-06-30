package com.example.APIgateway.client;


import com.example.APIgateway.commondtos.ProductionOrdersDto;
import com.example.APIgateway.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(
        name = "ProductionModule",
        url = "http://localhost:8084/orders",configuration = FeignConfig.class
)
public interface ProductionClient {
    @GetMapping()
    List<ProductionOrdersDto> getAllOrders();
    @GetMapping("/{id}")
    ProductionOrdersDto getOrderById(@PathVariable int id);
    @PostMapping()
    void createOrder(@RequestBody ProductionOrdersDto productionOrdersDto);
    @PostMapping("/{id}")
    ProductionOrdersDto updateOrderById(@PathVariable int id,@RequestBody ProductionOrdersDto productionOrdersDto);
    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable int id);
}
