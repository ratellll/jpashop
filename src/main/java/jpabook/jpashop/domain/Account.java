package jpabook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    private Long point;

    private Long balance;

    @OneToOne(mappedBy = "account",fetch = FetchType.LAZY)
    private Member member;

}
