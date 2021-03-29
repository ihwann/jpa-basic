package hello.jpa;

import hello.jpa.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {

        // 애플리케이션 로딩시점 하나만 호출
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello_jpa");

        // 트랜잭션 오픈
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("test");

            em.persist(member);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();

        } finally {
            em.close();
            emf.close();
        }

    }
}
