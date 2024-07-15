package jpabook.jpashop.service;


import jakarta.transaction.Transactional;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.fail;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

        @Autowired
        MemberService memberService;
        @Autowired
        MemberRepository memberRepository;

    @Test
    @Rollback(false)
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("빈이");

        //when
        Long saveId = memberService.join(member);

        //then
        Assertions.assertEquals(member, memberRepository.findOne(saveId));

     }

@Test
public void 중복회원_예외() throws Exception{
    //given
    Member member1 = new Member();
    Member member2 = new Member();
    member1.setName("빈");
    member2.setName("빈");

    //when
    memberService.join(member1);
    try {
        memberService.join(member2);
    }catch (IllegalStateException e){
        return;
    }

    //then
    fail("예외 발생 X");

 }


}


