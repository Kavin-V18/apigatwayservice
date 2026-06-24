package com.example.APIgateway.client;


import com.example.PlantsCarModule.dto.CarModelDto;
import com.example.PlantsCarModule.dto.ManufacturingPlantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@FeignClient(
        name = "PlantsCarModule",
        url = "http://localhost:8082"
)
public interface CarPlantClient {
    @GetMapping("/carmodel")
    List<Optional> getAllCarModel();
    @GetMapping("/carmodel/id")
    CarModelDto getCarModelById(int id);
    @PostMapping("/carmodel")
    void createCarModel(CarModelDto carModelDto);
    @PostMapping("/carmodel/id")
    CarModelDto updateCarModelById(int id, CarModelDto carModelDto);
    @DeleteMapping("/carmodel/id")
    void deleteCarModel(int id);

    @GetMapping("/manufacturingplant")
    List<Optional> getAllManufacturingPlant();
    @GetMapping("/manufacturingplant/id")
    ManufacturingPlantDto getManufacturingPlantById(int id);
    @PostMapping("/manufacturingplant")
    void createManufacturingPlant(ManufacturingPlantDto manufacturingPlantDto);
    @PostMapping("/manufacturingplant/id")
    ManufacturingPlantDto updateManufacturingPlantById(int id, ManufacturingPlantDto manufacturingPlantDto);
    @DeleteMapping("/manufacturingplant/id")
    void deleteManufacturingPlant(int id);
}
