package com.example.APIgateway.client;



import com.example.APIgateway.commondtos.AuditLogDto;
import com.example.APIgateway.commondtos.ServiceHistoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@FeignClient(
        name = "HistoryAndLogsModule",
        url = "http://localhost:8086"
)
public interface HistoryLogsClient {
    @GetMapping("/servicehistory")
    List<Optional> getAllServiceHistory();
    @GetMapping("/servicehistory/id")
    ServiceHistoryDto getServiceHistoryById(int id);
    @PostMapping("/servicehistory")
    void createServiceHistory(ServiceHistoryDto serviceHistoryDto);
    @PostMapping("/servicehistory/id")
    ServiceHistoryDto updateServiceHistoryById(int id, ServiceHistoryDto serviceHistoryDto);
    @DeleteMapping("/servicehistory/id")
    void deleteServiceHistory(int id);

    @GetMapping("/auditlog")
    List<Optional> getAllAuditLog();
    @GetMapping("/auditlog/id")
    AuditLogDto getAuditLogById(int id);
    @PostMapping("/auditlog")
    void createAuditLog(AuditLogDto auditLogDto);
    @PostMapping("/auditlog/id")
    AuditLogDto updateAuditLogById(int id, AuditLogDto auditLogDto);
    @DeleteMapping("/auditlog/id")
    void deleteAuditLog(int id);
}
