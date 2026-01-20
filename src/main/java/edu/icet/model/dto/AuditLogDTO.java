package edu.icet.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AuditLogDTO {
    private Long id;
    private String action;
    private String userId;
    private String details;
    private LocalDateTime timestamp;
}