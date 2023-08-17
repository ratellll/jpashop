package jpabook.jpashop.domain.item;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 상속관계 매핑 전략을 설정한다.
@DiscriminatorColumn(name = "dtype") // 부모 클래스에 구분 컬럼을 지정한다.
@Getter @Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

}