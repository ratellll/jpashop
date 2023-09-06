package jpabook.jpashop.repository;


import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor // final이 있는 필드만 가지고 생성자를 만들어준다.
public class OrderRepository {
    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id); // 단건 조회
    }

    //public List<Order> findAll(OrderSearch orderSearch) { // 동적 쿼리를 위해 OrderSearch를 파라미터로 받는다.
}
