package com.example.APIgateway.commondtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogDto {
    @NotBlank
    private String table_name;
    private int record_id;

    private String action;
    @NotBlank
    private String changed_data;
    //foreign-key --user
    private Long performed_by;
    @NotBlank
    private String ip_address;
    @NotNull
    private LocalDateTime created_at;
    @NotNull
    private Long created_by;
    @NotNull
    private LocalDateTime last_modified_at;
    @NotNull
    private Long last_modified_by;
}
