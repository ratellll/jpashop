package jpabook.jpashop.service;


import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //읽기 전용 트랜잭션, 조회할 때 성능 최적화
// JPA의 모든 데이터 변경은 트랜잭션 안에서 실행되어야 한다. public 메서드에만 적용된다.
@RequiredArgsConstructor //final이 있는 필드만 가지고 생성자를 만들어준다.
public class MemberService {


    private final MemberRepository memberRepository;

    //@Autowired //생성자가 하나일 경우 생략 가능
    //회원가입
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member)  {
        //EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
            //예외처리
        }
    }
    //회원전체조회

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }


    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }


}
