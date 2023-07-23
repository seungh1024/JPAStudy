package com.seungh1024;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Movie movie = new Movie();
            movie.setDirector("aaa");
            movie.setActor("bbb");
            movie.setName("mission impossible");
            movie.setPrice(10000);
            em.persist(movie);

            em.flush();
            em.clear();
            Item findMovie = em.find(Item.class, movie.getId());
            System.out.println("findMovie : "+findMovie.getName());

            Member member = new Member();
            member.setUsername("user1");
            member.setCreatedBy("kim");
            member.setCreatedDate(LocalDateTime.now());
            em.persist(member);


            tx.commit();
        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
