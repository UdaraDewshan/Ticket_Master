package edu.icet.service.strategy;

import edu.icet.model.dto.PriceResponse;
import edu.icet.model.entity.Event;
import edu.icet.model.entity.User;

public interface PricingStrategy {
    PriceResponse calculatePrice(User user, Event event);
}
