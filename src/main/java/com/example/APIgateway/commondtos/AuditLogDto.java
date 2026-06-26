package com.example.APIgateway.commondtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogDto {
    @NotBlank
    private String table_name;
    @NotBlank
    private int record_id;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private String action;
    @NotBlank
    private String changed_data;
    @NotBlank
    //foreign-key --user
    private Long performed_by;
    @NotBlank
    private String ip_address;
    @CreationTimestamp
    @NotNull
    private LocalDateTime created_at;
    @NotNull
    private String created_by;
    @UpdateTimestamp
    @NotNull
    private LocalDateTime last_modified_at;
    @NotNull
    private String last_modified_by;
}
