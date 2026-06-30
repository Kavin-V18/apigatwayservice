package com.example.APIgateway.client;

import com.example.APIgateway.commondtos.SupplierDto;
import com.example.APIgateway.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(
        name = "SuppliersModule",
        url = "http://localhost:8083/suppliers",configuration = FeignConfig.class
)
public interface SupplierClient {

    @GetMapping
    List<SupplierDto> getAllSuppliers();

    @GetMapping("/{id}")
    SupplierDto getSupplierById(@PathVariable int id);

    @PostMapping
    void createSupplier(@RequestBody SupplierDto supplierDto);

    @PostMapping("/{id}")
    SupplierDto updateSupplierById(
            @PathVariable int id,
            @RequestBody SupplierDto supplierDto
    );
    @DeleteMapping("/{id}")
    void deleteSupplier(@PathVariable("id") int id);
}
