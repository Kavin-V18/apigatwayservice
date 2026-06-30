package com.example.APIgateway.client;

import com.example.APIgateway.commondtos.CarModelDto;
import com.example.APIgateway.commondtos.ManufacturingPlantDto;
import com.example.APIgateway.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "PlantsCarModule",
        url = "http://localhost:8082",configuration = FeignConfig.class
)
public interface CarPlantClient {
    @GetMapping("/carmodel")
    List<CarModelDto> getAllCarModel();
    @GetMapping("/carmodel/{id}")
    CarModelDto getCarModelById(@PathVariable int id);
    @PostMapping("/carmodel")
    void createCarModel(@RequestBody CarModelDto carModelDto);
    @PostMapping("/carmodel/{id}")
    CarModelDto updateCarModelById(@PathVariable int id,@RequestBody CarModelDto carModelDto);
    @DeleteMapping("/carmodel/{id}")
    void deleteCarModel(@PathVariable int id);

    @GetMapping("/manufacturingplant")
    List<ManufacturingPlantDto> getAllManufacturingPlant();
    @GetMapping("/manufacturingplant/{id}")
    ManufacturingPlantDto getManufacturingPlantById(@PathVariable int id);
    @PostMapping("/manufacturingplant")
    void createManufacturingPlant(@RequestBody ManufacturingPlantDto manufacturingPlantDto);
    @PostMapping("/manufacturingplant/{id}")
    ManufacturingPlantDto updateManufacturingPlantById(@PathVariable int id,@RequestBody ManufacturingPlantDto manufacturingPlantDto);
    @DeleteMapping("/manufacturingplant/{id}")
    void deleteManufacturingPlant(@PathVariable int id);
}
