package edu.icet.service.strategy.impl;

import edu.icet.model.dto.PriceResponse;
import edu.icet.model.entity.Event;
import edu.icet.model.entity.User;
import edu.icet.service.strategy.PricingStrategy;
import org.springframework.stereotype.Component;
import java.util.Collections;

@Component("REGULAR")
public class RegularPricingStrategy implements PricingStrategy {
    @Override
    public PriceResponse calculatePrice(User user, Event event) {
        return PriceResponse.builder()
                .finalPrice(event.getBasePrice())
                .notifications(Collections.emptyList())
                .build();
    }
}