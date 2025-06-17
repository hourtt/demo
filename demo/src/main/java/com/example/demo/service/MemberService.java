package com.example.demo.service;

import com.example.demo.Member;
import com.example.demo.repository.MemoryMemberRepository;
import com.example.demo.repository.SpringDataJpaMemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    // private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    private final SpringDataJpaMemberRepository memberRepository;

    public MemberService(SpringDataJpaMemberRepository repository) {
        this.memberRepository = repository;
    }

    public Long join(Member member) {
        Optional<Member> findMember = memberRepository.findByName(member.getName());
        if (findMember.isEmpty()) {
            validateDuplicateMember(member);
            memberRepository.save(member);
            return member.getId();
        } else {
            return null;
        }

//        System.out.println("Before member : " + member.getId());
//        memberRepository.save(member);
//        System.out.println("After member : " + member.getId());
//        return member.getId();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("Duplicate Student");
        });
    }


}
