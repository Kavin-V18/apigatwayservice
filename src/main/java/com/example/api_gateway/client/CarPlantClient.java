package com.example.api_gateway.client;

import com.example.api_gateway.commondtos.CarModelDto;
import com.example.api_gateway.commondtos.ManufacturingPlantDto;
import com.example.api_gateway.config.FeignConfig;
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
    @PutMapping("/carmodel/{id}")
    CarModelDto updateCarModelById(@PathVariable int id,@RequestBody CarModelDto carModelDto);
    @DeleteMapping("/carmodel/{id}")
    void deleteCarModel(@PathVariable int id);

    @GetMapping("/manufacturingplant")
    List<ManufacturingPlantDto> getAllManufacturingPlant();
    @GetMapping("/manufacturingplant/{id}")
    ManufacturingPlantDto getManufacturingPlantById(@PathVariable int id);
    @PostMapping("/manufacturingplant")
    void createManufacturingPlant(@RequestBody ManufacturingPlantDto manufacturingPlantDto);
    @PutMapping("/manufacturingplant/{id}")
    ManufacturingPlantDto updateManufacturingPlantById(@PathVariable int id,@RequestBody ManufacturingPlantDto manufacturingPlantDto);
    @DeleteMapping("/manufacturingplant/{id}")
    void deleteManufacturingPlant(@PathVariable int id);
}
