package com.example.APIgateway.controller;

import com.example.APIgateway.client.NotificationClient;
import com.example.DeliveryNotificationModule.dto.NotificationDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationGatwayController {
      private final NotificationClient notificationClient;
      public NotificationGatwayController(NotificationClient notificationClient){
          this.notificationClient=notificationClient;
      }
    @GetMapping()
    public List<Optional> getNotification() {
        return notificationClient.getAllNotifications();
    }
    @GetMapping("/{id}")
    public NotificationDto getOrderById(@PathVariable int id){
        return notificationClient.getNotificationById(id);
    }
    @PostMapping()
    public String createOrder(@Valid @RequestBody NotificationDto notificationDto){
        notificationClient.createNotification(notificationDto);
        return "order created successfully";
    }
    @PostMapping("/{id}")
    public NotificationDto UpdateOrder(@PathVariable int id,@Valid  @RequestBody NotificationDto notificationDto){
        return  notificationClient.updateNotificationById(id,notificationDto);
    }
    @DeleteMapping("/{id}")
    public  String deleteOrder(@PathVariable int id){
        notificationClient.deleteNotification(id);
        return "order deleted Successfully";
    }
}
