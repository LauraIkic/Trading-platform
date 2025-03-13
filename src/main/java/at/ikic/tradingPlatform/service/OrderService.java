package at.ikic.tradingPlatform.service;

import at.ikic.tradingPlatform.entity.Order;
import at.ikic.tradingPlatform.kafka.producer.OrderRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    @Autowired
    private OrderRequestProducer orderRequestProducer;

    public void addOrderToMarket(Order order) {
        orderRequestProducer.sendOrderToKafka(order);
    }
}
