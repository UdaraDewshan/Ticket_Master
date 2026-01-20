package edu.icet.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SeatDTO {
    private Long id;
    private String seatNumber;
    private String status;
    private Long eventId;
    private String heldByUserId;
    private LocalDateTime holdExpiry;
}