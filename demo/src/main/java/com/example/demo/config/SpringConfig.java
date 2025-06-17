package com.example.demo.config;

import com.example.demo.repository.JpaMemberRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import com.example.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import jakarta.persistence.EntityManager;

//@Configuration
public class SpringConfig {

//    private final DataSource dataSource;
//    private final EntityManager entityManager;
//
//    public SpringConfig(DataSource dataSource, EntityManager entityManager) {
//        this.dataSource = dataSource;
//        this.entityManager = entityManager;
//    }
//    @Bean
//    public MemberRepository memberRepository() {
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(entityManager);
//    }
//    //MemberService
//    @Bean
//    public MemberService getMemberService(){
//        return new MemberService();
//    }
//
//    //MemberRepository
//    @Bean
//    public MemberRepository getMemoryRepository(){
//        return new MemoryMemberRepository();
//    }
//
//    private final MemberRepository memberRepository;
//    public SpringConfig(DataSource dataSource, EntityManager entityManager, MemberRepository memberRepository) {
//        this.dataSource = dataSource;
//        this.entityManager = entityManager;
//        this.memberRepository = memberRepository;
//    }

}
