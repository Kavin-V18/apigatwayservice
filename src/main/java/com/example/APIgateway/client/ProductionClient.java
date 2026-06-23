package com.example.APIgateway.client;

import com.example.ProductionModule.dto.ProductionOrdersDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
@FeignClient(
        name = "ProductionModule",
        url = "http://localhost:8084/orders"
)
public interface ProductionClient {
    @GetMapping()
    List<Optional> getAllOrders();
    @GetMapping("/id")
    ProductionOrdersDto getOrderById(int id);
    @PostMapping()
    void createOrder(ProductionOrdersDto productionOrdersDto);
    @PostMapping("/id")
    ProductionOrdersDto updateOrderById(int id, ProductionOrdersDto productionOrdersDto);
    @DeleteMapping("/id")
    void deleteOrder(int id);
}
