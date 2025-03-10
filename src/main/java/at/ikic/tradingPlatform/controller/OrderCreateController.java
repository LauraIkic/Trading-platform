package at.ikic.tradingPlatform.controller;

import at.ikic.tradingPlatform.dto.request.OrderCreateDto;
import at.ikic.tradingPlatform.entity.Order;
import at.ikic.tradingPlatform.mapper.OrderCreateMapper;
import at.ikic.tradingPlatform.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderCreateController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderCreateMapper orderCreateMapper;


    @PostMapping("/order")
    private void createOrder(@RequestBody OrderCreateDto data) {
        Order order = new Order();
        orderCreateMapper.mapToEntity(order, data);
        orderRepository.save(order);
    }

    @GetMapping("/orders")
    private List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
