package com.example.api_gateway.commondtos;


import com.example.api_gateway.Action;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogDto {
    private String tableName;
    private Integer recordId;
    private Action action;
    private String changedData;
    private String ipAddress;
}
