package jpabook.jpashop.domain.item;


import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "items") // 다대다 관계는 중간에 테이블을 하나 더 만들어서 관리한다.
    private List<Category> categories = new ArrayList<>();

}
