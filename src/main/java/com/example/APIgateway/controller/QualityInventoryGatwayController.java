package com.example.APIgateway.controller;

import com.example.APIgateway.client.QualityInventoryClient;
import com.example.APIgateway.commondtos.QualityInspectionDto;
import com.example.APIgateway.commondtos.VehicleInventoryDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class QualityInventoryGatwayController {
    private final QualityInventoryClient qualityInventoryClient;

    @GetMapping("/qualityinspection")
    public List<QualityInspectionDto> getQualityInventory() {
        return qualityInventoryClient.getAllQualityInspection();
    }
    @GetMapping("/qualityinspection/{id}")
    public QualityInspectionDto getQualityInventoryById(@PathVariable int id){
        return qualityInventoryClient.getQualityInspectionById(id);
    }
    @PostMapping("/qualityinspection")
    public String createQualityInventory(@Valid @RequestBody QualityInspectionDto qualityInspectionDto){
        qualityInventoryClient.createQualityInspection(qualityInspectionDto);
        return "Quality inspection  created successfully";
    }
    @PostMapping("/qualityinspection/{id}")
    public QualityInspectionDto UpdateQualityInventory(@PathVariable int id,@Valid  @RequestBody QualityInspectionDto qualityInspectionDto){
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
    public VehicleInventoryDto getVehicleInventoryById(@PathVariable int id) {
        return qualityInventoryClient.getVehicleInventoryById(id);
    }
    @PostMapping("/vehicleinventory")
    public String createVehicleInventory(@Valid @RequestBody VehicleInventoryDto vehicleInventoryDto){
        qualityInventoryClient.createVehicleInventory(vehicleInventoryDto);
        return "vechicle inventory created successfully";
    }
    @PostMapping("/vehicleinventory/{id}")
    public VehicleInventoryDto updateVehicleInventory(@PathVariable int id,@RequestBody VehicleInventoryDto vehicleInventoryDto){
        return qualityInventoryClient.updateVehicleInventoryById(id,vehicleInventoryDto);
    }
    @DeleteMapping("/vehicleinventory/{id}")
    public  String deleteVehicleInventory(@PathVariable int id){
        qualityInventoryClient.deleteVehicleInventory(id);
        return "vechicle inventory deleted successfully";
    }
}
