package com.example.api_gateway.controller;

import com.example.api_gateway.client.SupplierClient;
import com.example.api_gateway.commondtos.SupplierDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/{id}")
    public SupplierDto updateSupplier(@PathVariable int id,@Valid  @RequestBody SupplierDto supplierDto){
        return  supplierClient.updateSupplierById(id,supplierDto);
    }
    @DeleteMapping("/{id}")
    public  String deleteSupplier(@PathVariable int id){
           supplierClient.deleteSupplier(id);
           return "supplier deleted Successfully";
    }
    @PatchMapping("/{id}")
    public SupplierDto patchSupplier(@PathVariable int id,
                                     @RequestBody SupplierDto supplierDto){
       return supplierClient.patchSupplier(id, supplierDto);
    }
}
