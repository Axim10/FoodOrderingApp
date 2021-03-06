package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.AddressEntity;
import com.upgrad.FoodOrderingApp.service.entity.OrderEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<OrderEntity> getOrdersByAddress(AddressEntity addressEntity) {
        try {
            return entityManager.createNamedQuery("orderByAddress", OrderEntity.class).setParameter("address", addressEntity).getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public OrderEntity createOrder(OrderEntity orderEntity) {
        entityManager.persist(orderEntity);
        return orderEntity;
    }
}
