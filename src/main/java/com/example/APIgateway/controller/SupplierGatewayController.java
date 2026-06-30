package com.example.APIgateway.controller;

import com.example.APIgateway.client.SupplierClient;
import com.example.APIgateway.commondtos.SupplierDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/suppliers")
@RequiredArgsConstructor
public class SupplierGatewayController {
    private final SupplierClient supplierClient;
    @GetMapping()
    public List<SupplierDto> getSuppliers() {
        return supplierClient.getAllSuppliers();
    }
    @GetMapping("/{id}")
    public SupplierDto getSupplierById(@PathVariable int id){
        return supplierClient.getSupplierById(id);
    }
@PostMapping()
    public String createSuppliers(@Valid @RequestBody SupplierDto supplierDto){
         supplierClient.createSupplier(supplierDto);
         return "supplier created successfully";
    }
    @PostMapping("/{id}")
    public SupplierDto UpdateSupplier(@PathVariable int id,@Valid  @RequestBody SupplierDto supplierDto){
        return  supplierClient.updateSupplierById(id,supplierDto);
    }
    @DeleteMapping("/{id}")
    public  String deleteSupplier(@PathVariable int id){
           supplierClient.deleteSupplier(id);
           return "supplier deleted Successfully";
    }
}
