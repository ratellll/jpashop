package jpabook.jpashop.domain;


import jakarta.persistence.*;
import jpabook.jpashop.exception.NotEnoughStockException;
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

    private int point;

    private int balance;

    @OneToOne(mappedBy = "account",fetch = FetchType.LAZY)
    private Member member;


    //==비즈니스 로직==//

    /**
     * 잔고 증가
     * @param addBalance
     */
    public void addBalance(int addBalance) {
        this.balance += addBalance;
    }


    /**
     * 잔고 감소
     */
    public void removeBalance(int totalPrice) {
        int restBalance = this.balance - totalPrice;
        if (restBalance < totalPrice) {
            throw new NotEnoughStockException("need more Money");
        }
        this.balance = restBalance;
    }

}
