package edu.icet.model.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class PriceResponse {
    private Double finalPrice;
    private List<String> notifications;
}