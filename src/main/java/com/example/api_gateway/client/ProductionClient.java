package com.example.api_gateway.client;


import com.example.api_gateway.commondtos.ProductionOrdersDto;
import com.example.api_gateway.config.FeignConfig;
import com.example.api_gateway.responsedtos.ProductionOrderResponse;
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
    ProductionOrderResponse getOrderById(@PathVariable int id);
    @PostMapping()
    void createOrder(@RequestBody ProductionOrdersDto productionOrdersDto);
    @PutMapping("/{id}")
    ProductionOrdersDto updateOrderById(@PathVariable int id,@RequestBody ProductionOrdersDto productionOrdersDto);
    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable int id);
}
