package com.example.APIgateway.client;


import com.example.APIgateway.commondtos.QualityInspectionDto;
import com.example.APIgateway.commondtos.VehicleInventoryDto;
import com.example.APIgateway.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "QuantityandInventoryModule",
        url = "http://localhost:8087",configuration = FeignConfig.class
)
public interface QualityInventoryClient {
    @GetMapping("/qualityinspection")
    List<QualityInspectionDto> getAllQualityInspection();
    @GetMapping("/qualityinspection/{id}")
    QualityInspectionDto getQualityInspectionById(@PathVariable int id);
    @PostMapping("/qualityinspection")
    void createQualityInspection(@PathVariable QualityInspectionDto qualityInspectionDto);
    @PostMapping("/qualityinspection/{id}")
    QualityInspectionDto updateQualityInspectionById(@PathVariable int id,@RequestBody QualityInspectionDto qualityInspectionDto);
    @DeleteMapping("/qualityinspection/{id}")
    void deleteQualityInspection(@PathVariable int id);

    @GetMapping("/vehicleinventory")
    List<VehicleInventoryDto> getAllVehicleInventory();
    @GetMapping("/vehicleinventory/{id}")
    VehicleInventoryDto getVehicleInventoryById(@PathVariable int id);
    @PostMapping("/vehicleinventory")
    void createVehicleInventory(@RequestBody VehicleInventoryDto vehicleInventoryDto);
    @PostMapping("/vehicleinventory/{id}")
    VehicleInventoryDto updateVehicleInventoryById(@PathVariable int id,@RequestBody VehicleInventoryDto vehicleInventoryDto);
    @DeleteMapping("/vehicleinventory/{id}")
    void deleteVehicleInventory(@PathVariable  int id);
}
