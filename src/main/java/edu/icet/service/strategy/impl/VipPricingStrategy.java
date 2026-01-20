package edu.icet.service.strategy.impl;

import edu.icet.model.dto.PriceResponse;
import edu.icet.model.entity.Event;
import edu.icet.model.entity.User;
import edu.icet.service.strategy.PricingStrategy;
import org.springframework.stereotype.Component;
import java.util.Collections;

@Component("VIP")
public class VipPricingStrategy implements PricingStrategy {
    @Override
    public PriceResponse calculatePrice(User user, Event event) {
        double price = event.getBasePrice();

        if (!event.isHighDemand()) {
            price = price * 0.90;
        }

        return PriceResponse.builder()
                .finalPrice(price)
                .notifications(Collections.emptyList())
                .build();
    }
}