package com.example.APIgateway.controller;

import com.example.APIgateway.client.CarPlantClient;
import com.example.PlantsCarModule.dto.CarModelDto;
import com.example.PlantsCarModule.dto.ManufacturingPlantDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CarPlantGatwayController {
    private final CarPlantClient carPlantClient;
    public CarPlantGatwayController(CarPlantClient carPlantClient){
        this.carPlantClient=carPlantClient;
    }
    @GetMapping("/carmodel")
    public List<Optional> getCarModel() {
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
    @PostMapping("/carmodel/{id}")
    public CarModelDto UpdateCarModel(@PathVariable int id,@Valid  @RequestBody CarModelDto carModelDto){
        return  carPlantClient.updateCarModelById(id,carModelDto);
    }
    @DeleteMapping("/carmodel/{id}")
    public  String deleteCarModel(@PathVariable int id){
        carPlantClient.deleteCarModel(id);
        return "CarModel deleted Successfully";
    }

    @GetMapping("/manufacturingplant")
    public List<Optional> getManufacturingPlant() {
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
    @PostMapping("/manufacturingplant/{id}")
    public ManufacturingPlantDto updateManufacturingPlant(@PathVariable int id,@RequestBody ManufacturingPlantDto manufacturingPlantDto){
        return carPlantClient.updateManufacturingPlantById(id,manufacturingPlantDto);
    }
    @DeleteMapping("/manufacturingplant/{id}")
    public  String deleteManufacturingPlant(@PathVariable int id){
        carPlantClient.deleteManufacturingPlant(id);
        return "ManufacturingPlant deleted successfully";
    }
}
