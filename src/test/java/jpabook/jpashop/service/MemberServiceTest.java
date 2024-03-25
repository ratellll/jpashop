package jpabook.jpashop.service;


import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional //테스트 끝나면 롤백 시켜줌
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
    public void 회원가입() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("bin");

        Member member2 = new Member();
        member2.setName("sol");
        //when
        Long saveId1 = memberService.join(member1);
        Long saveId2 = memberService.join(member2);
        //then
        assertEquals(member1, memberRepository.findOne(saveId1));
        assertEquals(member2, memberRepository.findOne(saveId2));

    }

    @Test
    public void 중복회원관리() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("bin");

        Member member2 = new Member();
        member2.setName("bin");
        //when
        memberService.join(member1);
        try {
            memberService.join(member2); //예외가 발생해야 한다.
        }catch (IllegalStateException e) {
            return;
        }
        //then
        fail("예외가 발생해야 한다.");
    }

}