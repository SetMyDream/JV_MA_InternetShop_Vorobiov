package com.internet.shop.dao.impl;

import com.internet.shop.dao.OrderDao;
import com.internet.shop.db.Storage;
import com.internet.shop.model.Order;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderDaoImpl implements OrderDao {
    @Override
    public Order create(Order order) {
        Storage.addOrder(order);
        return order;
    }

    @Override
    public Optional<Order> getById(Long id) {
        return getAll().stream()
                .filter(order -> order.getOrderId().equals(id))
                .findFirst();
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public boolean delete(Long orderId) {
        return Storage.orders.removeIf(o -> o.getOrderId().equals(orderId));
    }

    @Override
    public List<Order> getAll() {
        return Storage.orders;
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return getAll().stream()
                .filter(order -> order.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
