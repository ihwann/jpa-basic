package hello.jpa;

import hello.jpa.entity.Member;
import hello.jpa.enum2.RoleType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

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
            member.setName("ilhwankim");
            member.setAge(30);
            member.setCreatedDate(new Date());
            member.setLastModifiedDate(new Date());
            member.setRoleType(RoleType.ADMIN);

            em.persist(member);
            //Member findMember = em.find(Member.class, 1L);

            // delete row
            //em.remove(findMember);

            // update row
            //findMember.setName("ilhwan");


            // JPQL
            // JPQL은 테이블이 아닌 객체를 대상으로 검색하는 객체지향 쿼리
//            List<Member> resultList = em.createQuery("select m from Member as m ", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            for(Member member : resultList) {
//                System.out.println("member = " + member.toString());
//            }


            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();
    }
}
