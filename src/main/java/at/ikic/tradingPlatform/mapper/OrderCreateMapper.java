package at.ikic.tradingPlatform.mapper;

import at.ikic.tradingPlatform.Enum.TransactionStatus;
import at.ikic.tradingPlatform.dto.request.OrderCreateDto;
import at.ikic.tradingPlatform.entity.Coin;
import at.ikic.tradingPlatform.entity.Order;
import at.ikic.tradingPlatform.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class OrderCreateMapper {
    @Autowired
    private CoinRepository coinRepository;

    public void mapToEntity(Order order, OrderCreateDto dto) {
        Coin coin = coinRepository.findById(dto.getCoinId()).orElseThrow(() ->
                new IllegalArgumentException("Coin not found for ID: " + dto.getCoinId())
        );

        order.setCoin(coin);
        order.setPrice(coin.getCurrentPrice());

        order.setType(dto.getType());
        order.setStatus(TransactionStatus.OPEN);
        order.setQuantity(dto.getQuantity());

        order.setDate(Instant.now());
    }
}
