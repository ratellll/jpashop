package jpabook.jpashop.domain;


import jpabook.jpashop.execption.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();


    //비즈니스 로직//

    /**
     * 재고증가
     * @param quantity
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * 재고 감소
     */

    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock > 0) {
            throw new NotEnoughStockException("수량이 부족합니다");
        }
        this.stockQuantity = restStock;
    }


    }

