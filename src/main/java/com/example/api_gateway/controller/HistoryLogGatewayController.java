package com.example.api_gateway.controller;

import com.example.api_gateway.client.HistoryLogsClient;

import com.example.api_gateway.commondtos.AuditLogDto;
import com.example.api_gateway.commondtos.ServiceHistoryDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class HistoryLogGatewayController {
    private final HistoryLogsClient historyLogsClient;

    @GetMapping("/servicehistory")
    public List<ServiceHistoryDto> getServiceHistory() {
        return historyLogsClient.getAllServiceHistory();
    }
    @GetMapping("/servicehistory/{id}")
    public ServiceHistoryDto getServiceHistoryById(@PathVariable int id){
        return historyLogsClient.getServiceHistoryById(id);
    }
    @PostMapping("/servicehistory")
    public String createServiceHistory(@Valid @RequestBody ServiceHistoryDto serviceHistoryDto){
        historyLogsClient.createServiceHistory(serviceHistoryDto);
        return "Service History  created successfully";
    }
    @PutMapping("/servicehistory/{id}")
    public ServiceHistoryDto updateServiceHistory(@PathVariable int id,@Valid  @RequestBody ServiceHistoryDto serviceHistoryDto){
        return  historyLogsClient.updateServiceHistoryById(id,serviceHistoryDto);
    }
    @DeleteMapping("/servicehistory/{id}")
    public  String deleteServiceHistory(@PathVariable int id){
        historyLogsClient.deleteServiceHistory(id);
        return "Service History deleted Successfully";
    }
    @GetMapping("/auditlog")
    @PreAuthorize("hasRole('ADMIN')")
    public List<AuditLogDto> getAuditLog() {
        return historyLogsClient.getAllAuditLog();
    }
    @GetMapping("/auditlog/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public AuditLogDto getAuditLogById(@PathVariable int id) {
        return historyLogsClient.getAuditLogById(id);
    }
    @PostMapping("/auditlog")
    @PreAuthorize("hasRole('ADMIN')")
    public String createAuditLog(@Valid @RequestBody AuditLogDto auditLogDto){
        historyLogsClient.createAuditLog(auditLogDto);
        return "Audit Log created successfully";
    }
}
