package com.example.demo;

import com.example.demo.repository.MemoryMemberRepository;
import com.example.demo.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    MemberService memberService = new MemberService();
    @AfterEach
    void afterEach() {
        // 각 테스트가 끝날때마다 실행된다
        repository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("Member");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findById() {
        Member member1 = new Member();
        member1.setName("Member1");
        repository.save(member1);

        Member member = memberService.findOne(1L).get();
        Assertions.assertThat(member.getName()).isEqualTo(member.getName());
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> list = repository.findAll();
        int listSize = list.size();
        assertThat(listSize).isEqualTo(2);
    }

    @Test
    void memberNameCheck(){

    }

}