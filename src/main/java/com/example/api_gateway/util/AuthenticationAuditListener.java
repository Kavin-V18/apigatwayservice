package com.example.api_gateway.util;

import com.example.api_gateway.Action;
import com.example.api_gateway.client.HistoryLogsClient;
import com.example.api_gateway.commondtos.AuditLogDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationAuditListener {
    private final HistoryLogsClient historyLogClient;
    @EventListener
    public void onLoginSuccess(AuthenticationSuccessEvent event) {
        try {
            String username = event.getAuthentication().getName();
            AuditLogDto request = new AuditLogDto();
            request.setTableName("security_auth");
            request.setRecordId(1);
            request.setAction(Action.LOGIN_SUCCESS);
            request.setChangedData("User '" + username + "' successfully authenticated into the system.");
            request.setIpAddress(captureCurrentRequestIp());
               log.info("login request in api gateway"+request);
            historyLogClient.createAuditLog(request);
        } catch (Exception e) {
            log.info("Login success audit log failed: " + e.getMessage());
        }
    }
    @EventListener
    public void onLoginFailure(AbstractAuthenticationFailureEvent event) {
        try {
            String username = event.getAuthentication().getName();
            String failureReason = event.getException().getMessage();
            AuditLogDto request = new AuditLogDto();
            request.setTableName("security_auth");
            request.setRecordId(null);
            request.setAction(Action.LOGIN_FAILURE);
            request.setChangedData("Failed login attempt for user '" + username + "'. Reason: " + failureReason);
            request.setIpAddress(captureCurrentRequestIp());
            historyLogClient.createAuditLog(request);
        } catch (Exception e) {
            log.info("Login failure audit log failed: " + e.getMessage());
        }
    }
    private String captureCurrentRequestIp() {
        ServletRequestAttributes attribs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attribs != null) {
            HttpServletRequest request = attribs.getRequest();
            String proxiedHeader = request.getHeader("X-Forwarded-For");
            return (proxiedHeader == null) ? request.getRemoteAddr() : proxiedHeader.split(",")[0].trim();
        }
        return "UNKNOWN_IP";
    }
}
