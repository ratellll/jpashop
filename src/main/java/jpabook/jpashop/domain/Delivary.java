package jpabook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@Setter
public class Delivary {


    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;


    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliberyStatus status;
}
