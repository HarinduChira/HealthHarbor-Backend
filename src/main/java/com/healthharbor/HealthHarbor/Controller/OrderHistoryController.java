package com.healthharbor.HealthHarbor.Controller;

import com.healthharbor.HealthHarbor.Collection.OrderHistory;
import com.healthharbor.HealthHarbor.Service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/OrderHistory")
public class OrderHistoryController {

    @Autowired
    private OrderHistoryService orderHistoryService;

    @GetMapping
    public ResponseEntity<List<OrderHistory>> getAllOrderHistory() {
        return new ResponseEntity<List<OrderHistory>>(orderHistoryService.allOrderHistory(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderHistory> addOrderHistoryToDb(@RequestBody OrderHistory orderHistory) {
        OrderHistory newOrderHistory = orderHistoryService.addOrderHistory(orderHistory);

        return new ResponseEntity<>(newOrderHistory, HttpStatus.CREATED);
    }

}
