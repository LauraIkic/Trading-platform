package at.ikic.tradingPlatform.controller;

import at.ikic.tradingPlatform.dto.request.OrderCreateDto;
import at.ikic.tradingPlatform.entity.Coin;
import at.ikic.tradingPlatform.entity.Order;
import at.ikic.tradingPlatform.mapper.OrderCreateMapper;
import at.ikic.tradingPlatform.repository.CoinRepository;
import at.ikic.tradingPlatform.repository.OrderRepository;
import at.ikic.tradingPlatform.service.AuthService;
import at.ikic.tradingPlatform.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class OrderCreateController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderCreateMapper orderCreateMapper;

    @Autowired
    private WalletService walletService;

    @Autowired
    private CoinRepository coinRepository;

    @PostMapping("/order")
    private void createOrder(@RequestBody OrderCreateDto data) {
        Coin coin = coinRepository.findById(data.getCoinId()).orElseThrow(() ->
                new IllegalArgumentException("Coin not found for ID: " + data.getCoinId())
        );

        BigDecimal currentPrice =BigDecimal.valueOf(coin.getCurrentPrice());
        if (false == walletService.balanceSufficient(currentPrice)) {
            new IllegalArgumentException("Balance not sufficient");
        }

        Order order = new Order();
        orderCreateMapper.mapToEntity(order, data, coin);
        orderRepository.save(order);
    }
}
