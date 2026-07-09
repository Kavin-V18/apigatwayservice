package com.example.api_gateway.client;

import com.example.api_gateway.commondtos.AuditLogDto;
import com.example.api_gateway.commondtos.ServiceHistoryDto;
import com.example.api_gateway.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "HistoryAndLogsModule",
        url = "http://localhost:8086",configuration = FeignConfig.class
)
public interface HistoryLogsClient {
    @GetMapping("/servicehistory")
    List<ServiceHistoryDto> getAllServiceHistory();
    @GetMapping("/servicehistory/{id}")
    ServiceHistoryDto getServiceHistoryById(@PathVariable int id);
    @PostMapping("/servicehistory")
    void createServiceHistory(@RequestBody ServiceHistoryDto serviceHistoryDto);
    @PutMapping("/servicehistory/{id}")
    ServiceHistoryDto updateServiceHistoryById(@PathVariable int id,@RequestBody ServiceHistoryDto serviceHistoryDto);
    @DeleteMapping("/servicehistory/{id}")
    void deleteServiceHistory(@PathVariable int id);

    @GetMapping("/auditlog")
    List<AuditLogDto> getAllAuditLog();
    @GetMapping("/auditlog/{id}")
    AuditLogDto getAuditLogById(@PathVariable int id);
    @PostMapping("/auditlog")
    void createAuditLog(@RequestBody  AuditLogDto auditLogDto);
}
