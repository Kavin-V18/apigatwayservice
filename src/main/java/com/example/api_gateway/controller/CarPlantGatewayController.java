package com.example.api_gateway.controller;

import com.example.api_gateway.client.CarPlantClient;

import com.example.api_gateway.commondtos.CarModelDto;
import com.example.api_gateway.commondtos.ManufacturingPlantDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CarPlantGatewayController {
    private final CarPlantClient carPlantClient;

    @GetMapping("/carmodel")
    public List<CarModelDto> getCarModel() {
        return carPlantClient.getAllCarModel();
    }
    @GetMapping("/carmodel/{id}")
    public CarModelDto getCarModelById(@PathVariable int id){
        return carPlantClient.getCarModelById(id);
    }
    @PostMapping("/carmodel")
    public String createCarModel(@Valid @RequestBody CarModelDto carModelDto){
        carPlantClient.createCarModel(carModelDto);
        return "CarModel created successfully";
    }
    @PutMapping("/carmodel/{id}")
    public CarModelDto updateCarModel(@PathVariable int id,@Valid  @RequestBody CarModelDto carModelDto){
        return  carPlantClient.updateCarModelById(id,carModelDto);
    }
    @DeleteMapping("/carmodel/{id}")
    public  String deleteCarModel(@PathVariable int id){
        carPlantClient.deleteCarModel(id);
        return "CarModel deleted Successfully";
    }
    @GetMapping("/manufacturingplant")
    public List<ManufacturingPlantDto> getManufacturingPlant() {
        return carPlantClient.getAllManufacturingPlant();
    }
    @GetMapping("/manufacturingplant/{id}")
    public ManufacturingPlantDto getManufacturingPlantById(@PathVariable int id) {
      return carPlantClient.getManufacturingPlantById(id);
    }
    @PostMapping("/manufacturingplant")
    public String createManufacturingPlant(@Valid @RequestBody ManufacturingPlantDto manufacturingPlantDto){
        carPlantClient.createManufacturingPlant(manufacturingPlantDto);
        return "ManufacturingPlant created successfully";
    }
    @PutMapping("/manufacturingplant/{id}")
    public ManufacturingPlantDto updateManufacturingPlant(@PathVariable int id,@RequestBody ManufacturingPlantDto manufacturingPlantDto){
        return carPlantClient.updateManufacturingPlantById(id,manufacturingPlantDto);
    }
    @DeleteMapping("/manufacturingplant/{id}")
    public  String deleteManufacturingPlant(@PathVariable int id){
        carPlantClient.deleteManufacturingPlant(id);
        return "ManufacturingPlant deleted successfully";
    }
}
