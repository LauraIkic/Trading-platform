package at.ikic.tradingPlatform.service;

import at.ikic.tradingPlatform.entity.Marketplace;
import at.ikic.tradingPlatform.entity.Order;
import at.ikic.tradingPlatform.enums.TransactionType;
import at.ikic.tradingPlatform.repository.MarketPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private MarketPlaceRepository marketPlaceRepository;

    public void addOrderToMarket(Order order, TransactionType type) {
        Marketplace marketPlace = marketPlaceRepository.findFirstByOrderByIdAsc().orElse(null);
        List<Order> orderList = marketPlace.getOrders();

        if (TransactionType.BUY == type) {
            orderList.add(order);
        } else {
            orderList.remove(order);
        }

        marketPlace.setOrders(orderList);

        marketPlaceRepository.save(marketPlace);
    }
}
