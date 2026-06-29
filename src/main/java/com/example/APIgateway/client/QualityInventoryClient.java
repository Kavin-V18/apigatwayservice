package com.example.APIgateway.client;


import com.example.APIgateway.commondtos.QualityInspectionDto;
import com.example.APIgateway.commondtos.VehicleInventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@FeignClient(
        name = "QuantityandInventoryModule",
        url = "http://localhost:8087"
)
public interface QualityInventoryClient {
    @GetMapping("/qualityinspection")
    List<Optional> getAllQualityInspection();
    @GetMapping("/qualityinspection/id")
    QualityInspectionDto getQualityInspectionById(int id);
    @PostMapping("/qualityinspection")
    void createQualityInspection(QualityInspectionDto qualityInspectionDto);
    @PostMapping("/qualityinspection/id")
    QualityInspectionDto updateQualityInspectionById(int id, QualityInspectionDto qualityInspectionDto);
    @DeleteMapping("/qualityinspection/id")
    void deleteQualityInspection(int id);

    @GetMapping("/vehicleinventory")
    List<Optional> getAllVehicleInventory();
    @GetMapping("/vehicleinventory/id")
    VehicleInventoryDto getVehicleInventoryById(int id);
    @PostMapping("/vehicleinventory")
    void createVehicleInventory(VehicleInventoryDto vehicleInventoryDto);
    @PostMapping("/vehicleinventory/id")
    VehicleInventoryDto updateVehicleInventoryById(int id, VehicleInventoryDto vehicleInventoryDto);
    @DeleteMapping("/vehicleinventory/id")
    void deleteVehicleInventory(int id);
}
