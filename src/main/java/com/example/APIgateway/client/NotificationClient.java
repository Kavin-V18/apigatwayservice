package com.example.APIgateway.client;


import com.example.APIgateway.commondtos.NotificationDto;
import com.example.APIgateway.commondtos.VehicleDeliveryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
@FeignClient(
        name = "DeliveryNotificationModule",
        url = "http://localhost:8081"
)
public interface NotificationClient {
    @GetMapping("/notification")
    List<Optional> getAllNotifications();
    @GetMapping("/notification/id")
    NotificationDto getNotificationById(int id);
    @PostMapping("/notification")
    void createNotification(NotificationDto notificationDto);
    @PostMapping("/notification/id")
    NotificationDto updateNotificationById(int id, NotificationDto notificationDto);
    @DeleteMapping("/notification/id")
    void deleteNotification(int id);


    @GetMapping("/vehicledelivery")
    List<Optional> getAllVehicleDelivery();
    @GetMapping("/vehicledelivery/id")
    VehicleDeliveryDto getVehicleDeliveryById(int id);
    @PostMapping("/vehicledelivery")
    void createVehicleDelivery(VehicleDeliveryDto vehicleDeliveryDto);
    @PostMapping("/vehicledelivery/id")
    VehicleDeliveryDto updateVehicleDeliveryById(int id, VehicleDeliveryDto vehicleDeliveryDto);
    @DeleteMapping("/vehicledelivery/id")
    void deleteVehicleDelivery(int id);

}
