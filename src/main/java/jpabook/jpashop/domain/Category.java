package jpabook.jpashop.domain;


import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {


    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item", // 다대다 관계는 중간에 테이블을 하나 더 만들어서 관리한다.
            joinColumns = @JoinColumn(name = "category_id"), // 중간 테이블에 있는 카테고리 아이디
            inverseJoinColumns = @JoinColumn(name = "item_id")) // 중간 테이블에 있는 아이템 아이디)
    private List<Item> items = new ArrayList<>();



    @ManyToOne(fetch = FetchType.LAZY) // 다대일 관계
    @JoinColumn(name = "parent_id")
    private Category parent;


    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    //==연관관계 메서드==//
    // 양방향 연관관계에서 사용
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }
}
