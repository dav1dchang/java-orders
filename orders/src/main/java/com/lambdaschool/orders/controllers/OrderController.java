package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController
{
    @Autowired
    OrderService orderService;

    @GetMapping(value = "/advanceamount")
    public ResponseEntity<?> getOrdersWithAdvanceAmount()
    {
        List<Order> myOrderList = orderService.findOrdersWithAdvanceAmount();
        return new ResponseEntity<>(myOrderList,
                HttpStatus.OK);
    }

    @GetMapping(value = "/order/{ordernum}",
            produces = {"application/json"})
    public ResponseEntity<?> getOrderByNumber(
            @PathVariable
                    long ordernum)
    {
        Order o = orderService.findOrdersById(ordernum);
        return new ResponseEntity<>(o,
                HttpStatus.OK);
    }
}
