package com.healthharbor.HealthHarbor.Service;

import com.healthharbor.HealthHarbor.Collection.OrderHistory;
import com.healthharbor.HealthHarbor.Repository.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryService {

    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    public List<OrderHistory> allOrderHistory()
    {
        return orderHistoryRepository.findAll();
    }
    public OrderHistory addOrderHistory(OrderHistory orderHistory) {

        return orderHistoryRepository.save(orderHistory);
    }


}
