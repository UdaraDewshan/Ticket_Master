package edu.icet.service;

import edu.icet.model.dto.PriceResponse;
import edu.icet.model.entity.Event;
import edu.icet.model.entity.User;
import edu.icet.service.strategy.PricingStrategy;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class PricingService {

    private final Map<String, PricingStrategy> strategyMap;

    public PricingService(Map<String, PricingStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public PriceResponse calculate(User user, Event event) {
        String tierName = String.valueOf(user.getTier());

        PricingStrategy strategy = strategyMap.get(tierName);

        if (strategy == null) {
            strategy = strategyMap.get("REGULAR");
        }
        return strategy.calculatePrice(user, event);
    }

}