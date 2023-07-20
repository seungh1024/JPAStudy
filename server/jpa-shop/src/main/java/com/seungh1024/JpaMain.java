package com.seungh1024;

import com.seungh1024.domain.Order;
import com.seungh1024.domain.OrderItem;
import com.seungh1024.domain.OrderStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Order order = new Order(LocalDateTime.now(), OrderStatus.ORDER);
            em.persist(order);
            OrderItem orderItem = new OrderItem(1000,1);
            orderItem.changeOrder(order);

            System.out.println("==============");
            em.persist(orderItem);
            OrderItem orderItem1 = em.find(OrderItem.class, orderItem.getId());
            System.out.println(orderItem1.getOrderPrice());
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
