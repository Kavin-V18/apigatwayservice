package com.example.APIgateway.controller;

import com.example.APIgateway.client.HistoryLogsClient;

import com.example.APIgateway.commondtos.AuditLogDto;
import com.example.APIgateway.commondtos.ServiceHistoryDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class HistoryLogGatwayController {
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
    public String createServiceHistory(@Valid @RequestBody ServiceHistoryDto ServiceHistoryDto){
        historyLogsClient.createServiceHistory(ServiceHistoryDto);
        return "Service History  created successfully";
    }
    @PostMapping("/servicehistory/{id}")
    public ServiceHistoryDto UpdateServiceHistory(@PathVariable int id,@Valid  @RequestBody ServiceHistoryDto serviceHistoryDto){
        return  historyLogsClient.updateServiceHistoryById(id,serviceHistoryDto);
    }
    @DeleteMapping("/servicehistory/{id}")
    public  String deleteServiceHistory(@PathVariable int id){
        historyLogsClient.deleteServiceHistory(id);
        return "Service History deleted Successfully";
    }

    @GetMapping("/auditlog")
    public List<AuditLogDto> getAuditLog() {
        return historyLogsClient.getAllAuditLog();
    }
    @GetMapping("/auditlog/{id}")
    public AuditLogDto getAuditLogById(@PathVariable int id) {
        return historyLogsClient.getAuditLogById(id);
    }
    @PostMapping("/auditlog")
    public String createAuditLog(@Valid @RequestBody AuditLogDto auditLogDto){
        historyLogsClient.createAuditLog(auditLogDto);
        return "Audit Log created successfully";
    }
    @PostMapping("/auditlog/{id}")
    public AuditLogDto updateAuditLog(@PathVariable int id,@RequestBody AuditLogDto auditLogDto){
        return historyLogsClient.updateAuditLogById(id,auditLogDto);
    }
    @DeleteMapping("/auditlog/{id}")
    public  String deleteAuditLog(@PathVariable int id){
        historyLogsClient.deleteAuditLog(id);
        return "Audit Log deleted successfully";
    }
}
