package com.seungh1024;

import com.seungh1024.domain.Book;
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

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("kim");
            book.setIsbn("kkkkk");
            em.persist(book);

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
