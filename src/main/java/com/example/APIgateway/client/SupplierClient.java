package com.example.APIgateway.client;

import com.example.APIgateway.commondtos.SupplierDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(
        name = "SuppliersModule",
        url = "http://localhost:8083/suppliers"
)
public interface SupplierClient {

    @GetMapping
    List<Optional> getAllSuppliers();

    @GetMapping("/{id}")
    SupplierDto getSupplierById(@PathVariable("id") int id);

    @PostMapping
    void createSupplier(@RequestBody SupplierDto supplierDto);

    @PostMapping("/{id}")
    SupplierDto updateSupplierById(
            @PathVariable("id") int id,
            @RequestBody SupplierDto supplierDto
    );

    @DeleteMapping("/{id}")
    void deleteSupplier(@PathVariable("id") int id);
}
