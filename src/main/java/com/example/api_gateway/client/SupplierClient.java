package com.example.api_gateway.client;

import com.example.api_gateway.commondtos.SupplierDto;
import com.example.api_gateway.config.FeignConfig;
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

    @PutMapping("/{id}")
    SupplierDto updateSupplierById(
            @PathVariable int id,
            @RequestBody SupplierDto supplierDto
    );
    @DeleteMapping("/{id}")
    void deleteSupplier(@PathVariable("id") int id);

    @PatchMapping("/{id}")
    public SupplierDto patchSupplier(@PathVariable("id") int id,
                                     @RequestBody SupplierDto supplierDto);
}
