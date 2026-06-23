package com.example.APIgateway.client;

import com.example.DeliveryNotificationModule.dto.NotificationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
@FeignClient(
        name = "DeliveryNotificationModule",
        url = "http://localhost:8081/notification"
)
public interface NotificationClient {
    @GetMapping()
    List<Optional> getAllNotifications();
    @GetMapping("/id")
    NotificationDto getNotificationById(int id);
    @PostMapping()
    void createNotification(NotificationDto notificationDto);
    @PostMapping("/id")
    NotificationDto updateNotificationById(int id, NotificationDto notificationDto);
    @DeleteMapping("/id")
    void deleteNotification(int id);
}
