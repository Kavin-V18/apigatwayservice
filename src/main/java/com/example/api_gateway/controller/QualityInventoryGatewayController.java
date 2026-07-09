package com.example.api_gateway.controller;

import com.example.api_gateway.client.QualityInventoryClient;
import com.example.api_gateway.commondtos.QualityInspectionDto;
import com.example.api_gateway.commondtos.VehicleInventoryDto;
import com.example.api_gateway.responsedtos.InventoryResponse;
import com.example.api_gateway.responsedtos.QualityResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class QualityInventoryGatewayController {
    private final QualityInventoryClient qualityInventoryClient;

    @GetMapping("/qualityinspection")
    public List<QualityInspectionDto> getQualityInventory() {
        return qualityInventoryClient.getAllQualityInspection();
    }
    @GetMapping("/qualityinspection/{id}")
    public QualityResponse getQualityInventoryById(@PathVariable int id){
        log.info("api gateway response"+qualityInventoryClient.getQualityInspectionById(id));
        return qualityInventoryClient.getQualityInspectionById(id);
    }
    @PostMapping("/qualityinspection")
    public String createQualityInventory(@Valid @RequestBody QualityInspectionDto qualityInspectionDto){
        qualityInventoryClient.createQualityInspection(qualityInspectionDto);
        return "Quality inspection  created successfully";
    }
    @PutMapping("/qualityinspection/{id}")
    public QualityInspectionDto updateQualityInventory(@PathVariable int id,@Valid  @RequestBody QualityInspectionDto qualityInspectionDto){
        return  qualityInventoryClient.updateQualityInspectionById(id,qualityInspectionDto);
    }
    @DeleteMapping("/qualityinspection/{id}")
    public  String deleteQualityInventory(@PathVariable int id){
        qualityInventoryClient.deleteQualityInspection(id);
        return "Quality inspection deleted Successfully";
    }

    @GetMapping("/vehicleinventory")
    public List<VehicleInventoryDto> getVehicleInventory() {
        return qualityInventoryClient.getAllVehicleInventory();
    }
    @GetMapping("/vehicleinventory/{id}")
    public InventoryResponse getVehicleInventoryById(@PathVariable int id) {
        return qualityInventoryClient.getVehicleInventoryById(id);
    }
    @PostMapping("/vehicleinventory")
    public String createVehicleInventory(@Valid @RequestBody VehicleInventoryDto vehicleInventoryDto){
        qualityInventoryClient.createVehicleInventory(vehicleInventoryDto);
        return "vehicle inventory created successfully";
    }
    @PutMapping("/vehicleinventory/{id}")
    public VehicleInventoryDto updateVehicleInventory(@PathVariable int id,@RequestBody VehicleInventoryDto vehicleInventoryDto){
        return qualityInventoryClient.updateVehicleInventoryById(id,vehicleInventoryDto);
    }
    @DeleteMapping("/vehicleinventory/{id}")
    public  String deleteVehicleInventory(@PathVariable int id){
        qualityInventoryClient.deleteVehicleInventory(id);
        return "vehicle inventory deleted successfully";
    }
}
