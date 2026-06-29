package com.example.APIgateway.controller;

import com.example.APIgateway.client.NotificationClient;

import com.example.APIgateway.commondtos.NotificationDto;
import com.example.APIgateway.commondtos.VehicleDeliveryDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class NotificationGatwayController {
      private final NotificationClient notificationClient;

    @GetMapping("/notification")
    public List<NotificationDto> getNotification() {
        return notificationClient.getAllNotifications();
    }
    @GetMapping("/notification/{id}")
    public NotificationDto getNotificationById(@PathVariable int id){
        return notificationClient.getNotificationById(id);
    }
    @PostMapping("/notification")
    public String createNotification(@Valid @RequestBody NotificationDto notificationDto){
        notificationClient.createNotification(notificationDto);
        return "order created successfully";
    }
    @PostMapping("/notification/{id}")
    public NotificationDto UpdateNotification(@PathVariable int id,@Valid  @RequestBody NotificationDto notificationDto){
        return  notificationClient.updateNotificationById(id,notificationDto);
    }
    @DeleteMapping("/notification/{id}")
    public  String deleteNotification(@PathVariable int id){
        notificationClient.deleteNotification(id);
        return "order deleted Successfully";
    }


    @GetMapping("/vehicledelivery")
    public List<VehicleDeliveryDto> getVehicleDelivery() {
        return notificationClient.getAllVehicleDelivery();
    }
    @GetMapping("/vehicledelivery/{id}")
    public VehicleDeliveryDto getVehicleDeliveryById(@PathVariable int id){
        return notificationClient.getVehicleDeliveryById(id);
    }
    @PostMapping("/vehicledelivery")
    public String createVehicleDelivery(@Valid @RequestBody VehicleDeliveryDto vehicleDeliveryDto){
        notificationClient.createVehicleDelivery(vehicleDeliveryDto);
        return "order created successfully";
    }
    @PostMapping("/vehicledelivery/{id}")
    public VehicleDeliveryDto UpdateVehicleDelivery(@PathVariable int id,@Valid  @RequestBody VehicleDeliveryDto vehicleDeliveryDto){
        return  notificationClient.updateVehicleDeliveryById(id,vehicleDeliveryDto);
    }
    @DeleteMapping("/vehicledelivery/{id}")
    public  String deleteVehicleDelivery(@PathVariable int id){
        notificationClient.deleteVehicleDelivery(id);
        return "order deleted Successfully";
    }
}
