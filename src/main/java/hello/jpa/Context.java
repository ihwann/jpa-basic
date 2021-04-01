package hello.jpa;

import hello.jpa.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

public class Context {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello_jpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        et.begin();

        try {

            /*
             * 비영속 상태
             * 객체를 생성한 상태
             * EntityManger 에 종속이지 않은 상태
             */
            Member member = new Member();
            member.setId(3L);
            member.setName("나다");

            /*
             * 영속상태
             * 객체를 EntityManager에 저장
             * but persist로 db에 저장되진 않음
             */
            em.persist(member);

            // em.detach(member); 영속성 컨텍스트에서 제거
            // em.remove(member); 객체를 테이블에서 delete

            /*
             *  EntityTransaction에서 커밋하는 순간
             *  영속성 컨텍스트에 저장된 쿼리가 날라감
             */
            et.commit();
        } catch (Exception e ) {
            et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }


    }
}
