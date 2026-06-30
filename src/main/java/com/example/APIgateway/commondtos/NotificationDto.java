package com.example.APIgateway.commondtos;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class NotificationDto {

    @Enumerated(EnumType.STRING)
    private String recipientRole;
    @NotBlank
    private String message;
    @Enumerated(EnumType.STRING)
    private String notificationType;
    private Boolean isRead;
    private LocalDateTime createdAt;
    private Long created_by;
    private LocalDate last_modified_at;
    private Long last_modified_by;
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.isRead == null) {
            this.isRead = false;
        }
    }
}
