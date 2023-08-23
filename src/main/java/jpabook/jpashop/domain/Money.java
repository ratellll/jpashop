package jpabook.jpashop.domain;


import lombok.Getter;

import javax.persistence.*;

@Embeddable
@Getter

public class Money {

    private int bankCount;

    protected Money() {
    }
    public Money(int bankCount) {
        this.bankCount = bankCount;
    }
}
