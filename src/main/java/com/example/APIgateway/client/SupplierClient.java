package com.example.APIgateway.client;

import com.example.SuppliersModule.dto.SupplierDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@FeignClient(
        name = "ProductionModule",
        url = "http://localhost:8083/suppliers"
)
public interface SupplierClient {
    @GetMapping()
    List<Optional> getAllSuppliers();
    @GetMapping("/id")
    SupplierDto getSupplierById(int id);
    @PostMapping()
    void createSupplier(SupplierDto supplierDto);
    @PostMapping("/id")
    SupplierDto updateSupplierById(int id,SupplierDto supplierDto);
    @DeleteMapping("/id")
    void deleteSupplier(int id);
}
