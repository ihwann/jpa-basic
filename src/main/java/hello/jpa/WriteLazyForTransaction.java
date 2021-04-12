package hello.jpa;

import hello.jpa.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

public class WriteLazyForTransaction {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello_jpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        try {


            System.out.println("===============================");

            /*
             * sql 이 commit 바로 직전에 출력되는걸로 보아
             * persist 가 쿼리의 역할을 하는게 아닌
             * 영속성 컨텍스트에 저장한다는 것을 확인
             */


            et.commit();
        } catch (Exception e) {

            et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
