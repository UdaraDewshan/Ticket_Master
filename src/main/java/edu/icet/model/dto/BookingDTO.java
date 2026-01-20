package edu.icet.model.dto;

import lombok.Data;

@Data
public class BookingDTO {
    private Long id;
    private String userId;
    private Long seatId;
    private Double amountPaid;
    private String status;
}