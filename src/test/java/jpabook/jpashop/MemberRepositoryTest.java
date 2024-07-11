package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {

//    @Autowired MemberRepository memberRepository;
//
//    @Test
//    @Transactional // 테스트에있을경우 바로 rollback
//    //@Rollback(value = false) 롤백원하지않을경우
//    public void testMember() throws Exception{
//        //given
//        Member member = new Member();
//        member.setUsername("빈이");
//        //when
//        Long saveId = memberRepository.save(member);
//        Member findMember = memberRepository.find(saveId);
//
//        //then
//        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//        Assertions.assertThat(findMember).isEqualTo(member); //1차캐시에 들어가기떄문에 같음
//    }


    }

