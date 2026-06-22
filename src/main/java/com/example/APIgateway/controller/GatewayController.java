package com.example.APIgateway.controller;

import com.example.APIgateway.client.NotificationClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class GatewayController {
      private final NotificationClient notificationClient;
      public GatewayController(NotificationClient notificationClient){
          this.notificationClient=notificationClient;
      }
    @GetMapping("/notification")
    public List<Optional> getNotification() {
        return notificationClient.getAllNotifications();
    }
}
