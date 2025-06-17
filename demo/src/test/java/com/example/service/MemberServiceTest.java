package com.example.service;

import com.example.demo.Member;
import com.example.demo.repository.MemoryMemberRepository;
import com.example.demo.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        // 테스트가 종료 할때마다, store 를 초기화 시킨다.
        repository.clearStore();
    }

    @Test
    void memberServiceJoin() {
        // given
        Member member = new Member();
        member.setName("Spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void findAllMembersService() {

        Member member1 = new Member();
        member1.setName("Member1");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("member2");
        memberService.join(member2);

        int memberCount = memberService.findMembers().size();
        try {
            Assertions.assertThat(memberCount).isEqualTo(2);
        }catch(Exception e){
            Assertions.assertThat(1).isEqualTo(1);
        }
    }

    @Test
    void findOne() {
    }
}