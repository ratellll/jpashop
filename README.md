devtools 추가해서 html은 재시작없이 바로바로 확인 가능 (빌드 -> 리컴파일)


테이블 
- 외래키 하나로 양쪽 조인 가능
- 사실 방향이라는 개념이 없음
- 연관관계의 주인 : 외래키를 관리하는 참조 FK가 들어있는 테이블
- 
객체
- 참조용 필드가 있는쪽으로만 참조가능
- 한쪽만 참조하면 단방향
- 양쪽이 서로 참조하면 양방향 (사실 양방향이라는건 없고 단방향으로 양쪽이 참조한것) 
- 양방향 으로 할시 참조가 2군데  
- 둘중 테이블중 외래키를 관리할곳을 지정해야함




primary key 는 PK이 라고 부르고 각 테이블마다 가진 고유의 아이디이다 (중복되지 않는다)
PK를 참조하여 다른 테이블과 연결할 수 있다 외래키 (FK)

N:1 다대일 관계 : 항상 N쪽에 외래키넣기 


1대1 관계 (1:1): 어느 엔티티쪽에서 상대 엔티티와 반드시 단 하나의 관계가 형성되는것.
                ex) 회원과 주민등록번호 

1:N 관계(일대다 관계): 한쪽 엔티티가 관계를 맺은 엔티티쪽의 여러객체를 가질수있는것
                ex) 회원과 주문 (회원은 여러개의 주문을 가질수있다, 하지만 주문은 하나의 회원에만 속한다)

N:M 관계(다대다 관계): 양쪽 엔티티가 서로 관계를 맺을수있는것
                ex) 회원과 상품 (회원은 여러개의 상품을 가질수있고, 상품도 여러개의 회원을 가질수있다)


간접적으로 데이터를 삭제하는것 : soft delete 
                        ex) 회원을 삭제하면 회원의 주문목록은 삭제되지않고, 회원의 주문목록을 조회할때는 삭제된 회원의 주문목록은 조회되지않는다.
                            웬만하면 개인정보만 지우고 남겨둠. 
모든 데이터를 지우는것 : hard delete 
                        ex) 회원을 삭제하면 회원의 주문목록도 삭제된다. 개인 정보도 모두 삭제한다 


복합키가 있을때는 2정규형
복합키란 두개 이상의 컬럼으로 구성된 기본키를 말한다. 
복합키가 없을때는 3정규형


외래키가 있는곳을 연관관계의 주인으로 정해라
외래키가 있는곳이 연관관계의 주인이다. 
ex) 자동차와 바퀴가 있다고 가정하자. 자동차는 바퀴를 여러개 가질수있고, 바퀴는 자동차를 하나만 가질수있다. 
    이때 자동차가 바퀴를 가지고있는것이 아니라 바퀴가 자동차를 가지고있는것이다. 
    그렇기때문에 바퀴가 연관관계의 주인이다.



이론적으로 Getter , Setter는 모두 제공하지않고 필요한경우에만 제공한다. 하지만 실무에선 데이터 조회할 일이 많아서 
Getter는 모두 제공한다. Setter는 꼭 필요한경우에만 제공한다. 
Setter를 호출하면 데이터가 변경되기때문에 변경 포인트가 너무 많아서 유지보수가 어려워진다.
Setter를 제공하지않으면 변경이 필요한 경우, 해당 엔티티의 메서드를 추가하고 그 메서드를 호출하는 코드를 추가해야한다.

실무에선 ManyToOne, OneToMany 관계에서는 기본적으로 지연로딩을 사용해라 ManyToMany는 웬만하면 사용 x

***모든 연관관계는 지연로딩으로 설정하기***

즉시로딩(EAGER)이란 연관된 엔티티를 즉시 조회하는것을 말한다. 
즉시로딩은 연관된 엔티티를 함께 조회하기때문에 SQL조인을 사용한다.
즉시로딩은 JPQL에서 N+1 문제를 일으킨다. 
즉시로딩은 연관된 엔티티를 모두 조인해서 가져오기때문에 데이터가 많으면 성능이 저하된다.

지연로딩(LAZY)이란 연관된 엔티티를 실제 사용할때 조회하는것을 말한다.
지연로딩은 연관된 엔티티를 프록시로 조회한다.
지연로딩은 연관된 엔티티를 프록시로 조회하기때문에 실제 사용하는 시점에 쿼리를 실행한다.
지연로딩은 연관된 엔티티를 즉시조회하는것이 아니기때문에 N+1 문제가 발생하지않는다.
지연로딩은 영속성 컨텍스트에 찾는 엔티티가 이미 있으면 데이터베이스를 조회하지않고 영속성 컨텍스트에 있는 엔티티를 반환한다.
지연로딩은 영속성 컨텍스트에 찾는 엔티티가 없으면 데이터베이스를 조회하고, 조회한 엔티티를 영속성 컨텍스트에 저장하고 반환한다.

XtoONE으로 가는것들은 기본으로  EAGER로 설정되어있다.
ONEtoX으로 가는것들은 기본으로 LAZY로 설정되어있다.


***컬렉션은 필드에서 초기화 하자***

cascade는 영속성 전이를 말한다.
cascade = CascadeType.ALL 은 모든 cascade를 전파한다는 뜻이다.
cascade = CascadeType.PERSIST는 영속성 전이중에 PERSIST만 전파한다는 뜻이다.
cascade = CascadeType.MERGE는 영속성 전이중에 MERGE만 전파한다는 뜻이다.
cascade = CascadeType.REMOVE는 영속성 전이중에 REMOVE만 전파한다는 뜻이다.
cascade = CascadeType.REFRESH는 영속성 전이중에 REFRESH만 전파한다는 뜻이다.
cascade = CascadeType.DETACH는 영속성 전이중에 DETACH만 전파한다는 뜻이다.
cascade란 연관된 엔티티를 함께 저장하거나 삭제하는것을 말한다. 


스프링부트 신규설정 (엔티티(필드) -> 테이블(컬럼))
1. 카멜케이스 -> 언더스코어 (memberPoint -> member_point)
2. .(점) -> 언더스코어
3. 대문자 -> 소문자


SpringBoot는 apllication.설정에 아무것도없어도 memory db를 사용한다. (Test에서만 사용)

merge를 사용하는것보단 바꿀필드값을 set으로 잡는게좋다 
왜냐하면 merge를 사용할때 필드값이 빈값이면 NULL로 강제성업데이트를 하기떄문이다 실무에서 굉장히 위험