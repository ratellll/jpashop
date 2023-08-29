package jpabook.jpashop.domain;


import lombok.Getter;

import javax.persistence.*;

@Embeddable
@Getter
public class Money {

    private Integer bankCount;

    protected Money() {
    }
    public Money(Integer bankCount) {
        this.bankCount = bankCount;
    }
}
