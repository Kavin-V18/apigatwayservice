package com.example.APIgateway.client;

import com.example.APIgateway.commondtos.AuditLogDto;
import com.example.APIgateway.commondtos.ServiceHistoryDto;
import com.example.APIgateway.config.FeignConfig;
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
    @PostMapping("/servicehistory/{id}")
    ServiceHistoryDto updateServiceHistoryById(@PathVariable int id,@RequestBody ServiceHistoryDto serviceHistoryDto);
    @DeleteMapping("/servicehistory/{id}")
    void deleteServiceHistory(@PathVariable int id);

    @GetMapping("/auditlog")
    List<AuditLogDto> getAllAuditLog();
    @GetMapping("/auditlog/{id}")
    AuditLogDto getAuditLogById(@PathVariable int id);
    @PostMapping("/auditlog")
    void createAuditLog(@RequestBody  AuditLogDto auditLogDto);
    @PostMapping("/auditlog/{id}")
    AuditLogDto updateAuditLogById(@PathVariable int id,@RequestBody AuditLogDto auditLogDto);
    @DeleteMapping("/auditlog/{id}")
    void deleteAuditLog(@PathVariable int id);
}
