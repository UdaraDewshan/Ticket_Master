package edu.icet.service.aop;

import edu.icet.model.entity.AuditLog;
import edu.icet.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class AuditLoggingAspect {

    private final AuditLogRepository auditLogRepository;

    @AfterThrowing(pointcut = "@annotation(AuditFailure)", throwing = "ex")
    public void logFailure(JoinPoint joinPoint, Throwable ex) {

        String action = joinPoint.getSignature().getName();
        String details = ex.getMessage();

        AuditLog log = new AuditLog();
        log.setAction("FAILURE_IN_" + action.toUpperCase());
        log.setDetails(details);
        log.setTimestamp(LocalDateTime.now());



        auditLogRepository.save(log);

        System.out.println("⚠️ Audit Logged: " + details);
    }
}