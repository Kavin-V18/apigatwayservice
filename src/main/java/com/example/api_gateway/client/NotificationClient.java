package com.example.api_gateway.client;


import com.example.api_gateway.commondtos.NotificationDto;
import com.example.api_gateway.commondtos.VehicleDeliveryDto;
import com.example.api_gateway.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(
        name = "DeliveryNotificationModule",
        url = "http://localhost:8081",configuration = FeignConfig.class
)
public interface NotificationClient {
    @GetMapping("/notification")
    List<NotificationDto> getAllNotifications();
    @GetMapping("/notification/{id}")
    NotificationDto getNotificationById(@PathVariable int id);
    @PostMapping("/notification")
    void createNotification(@RequestBody  NotificationDto notificationDto);
    @PutMapping("/notification/{id}")
    NotificationDto updateNotificationById(@PathVariable int id,@RequestBody NotificationDto notificationDto);
    @DeleteMapping("/notification/{id}")
    void deleteNotification(@PathVariable int id);

    @GetMapping("/vehicledelivery")
    List<VehicleDeliveryDto> getAllVehicleDelivery();
    @GetMapping("/vehicledelivery/{id}")
    VehicleDeliveryDto getVehicleDeliveryById(@PathVariable int id);
    @PostMapping("/vehicledelivery")
    void createVehicleDelivery(@RequestBody VehicleDeliveryDto vehicleDeliveryDto);
    @PutMapping("/vehicledelivery/{id}")
    VehicleDeliveryDto updateVehicleDeliveryById(@PathVariable int id,@RequestBody VehicleDeliveryDto vehicleDeliveryDto);
    @DeleteMapping("/vehicledelivery/{id}")
    void deleteVehicleDelivery(@PathVariable int id);
}
