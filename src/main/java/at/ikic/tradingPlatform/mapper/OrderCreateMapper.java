package at.ikic.tradingPlatform.mapper;

import at.ikic.tradingPlatform.enums.TransactionStatus;
import at.ikic.tradingPlatform.dto.request.OrderCreateDto;
import at.ikic.tradingPlatform.entity.Coin;
import at.ikic.tradingPlatform.entity.Order;
import at.ikic.tradingPlatform.repository.CoinRepository;
import at.ikic.tradingPlatform.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class OrderCreateMapper {
    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private AuthService authService;


    public void mapToEntity(Order order, OrderCreateDto dto, Coin c) {
        order.setCoin(c);
        order.setPrice(c.getCurrentPrice());

        order.setType(dto.getType());
        order.setStatus(TransactionStatus.OPEN);
        order.setQuantity(dto.getQuantity());

        order.setUser(authService.getAuthenticatedUser());

        order.setDate(Instant.now());
    }
}
