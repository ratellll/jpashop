package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter  @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 다대일 관계
    @JoinColumn(name = "member_id") // 외래키
    private Member member; // 주문 회원

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) // 주문과 주문상품은 일대다 관계
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // 일대일 관계
    @JoinColumn(name = "delivery_id") // 외래키
    private Delivery delivery;

    private LocalDateTime orderDate; // 주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문상태 [ORDER, CANCEL]



}
