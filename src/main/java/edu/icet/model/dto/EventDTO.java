package edu.icet.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EventDTO {
    private Long id;
    private String name;
    private Double basePrice;
    private boolean isHighDemand;
    private LocalDateTime eventDate;
}