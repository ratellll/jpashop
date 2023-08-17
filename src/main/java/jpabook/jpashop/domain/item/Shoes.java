package jpabook.jpashop.domain.item;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S") // 싱글테이블 전략에서는 구분 컬럼을 꼭 넣어줘야 한다.
@Getter @Setter
public class Shoes extends Item{

        private String brand;
        private String material;
        private int size;
}
