package com.example.api_gateway.commondtos;


import com.example.api_gateway.util.NotificationType;
import com.example.api_gateway.util.RecipientRole;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class NotificationDto {
    private RecipientRole recipientRole;
    private NotificationType notificationType;
}
