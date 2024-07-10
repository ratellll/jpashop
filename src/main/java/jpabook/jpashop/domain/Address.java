package jpabook.jpashop.domain;


import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() { // public 으로 설정하지 않는이유는 무분별하게 사용이 될수있기떄문에
    }
}
