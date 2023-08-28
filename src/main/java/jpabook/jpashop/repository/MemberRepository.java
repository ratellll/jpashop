package jpabook.jpashop.repository;


import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository // 스프링 빈으로 등록
@RequiredArgsConstructor // final이 있는 필드만 가지고 생성자를 만들어준다.
public class MemberRepository {


    private final EntityManager em;



    public void save(Member member) {
        em.persist(member); // 영속성 컨텍스트에 저장
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id); // 단건 조회
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) // JPQL
                .getResultList();
            }

   public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class) // JPQL
                .setParameter("name", name)
                .getResultList();
    }
}
