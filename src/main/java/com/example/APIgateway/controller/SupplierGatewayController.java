package com.example.APIgateway.controller;

import com.example.APIgateway.client.SupplierClient;
import com.example.SuppliersModule.dto.SupplierDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/suppliers")
public class SupplierGatewayController {
    private final SupplierClient supplierClient;
    public SupplierGatewayController(SupplierClient supplierClient){
        this.supplierClient=supplierClient;
    }
    @GetMapping()
    public List<Optional> getSuppliers() {
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
