package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor // 파이널을 가진놈의 생성자를 만들어줌
public class MemberService {


    private final MemberRepository memberRepository;


    //회원가입
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    //회원 전체조회
    @Transactional(readOnly = true) // 성능최적화를 위한것 조회전용느낌으로
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true) // 성능최적화를 위한것 조회전용느낌으로
    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }



}
