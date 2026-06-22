package com.example.APIgateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Optional;
@FeignClient(
        name = "DeliveryNotificationModule",
        url = "http://localhost:8081/notification"
)
public interface NotificationClient {
    @GetMapping()
    List<Optional> getAllNotifications();
}
