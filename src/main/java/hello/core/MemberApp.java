package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        // 기존엔 MemberServiceImpl을 메인메서드에서 직접 생성을 해줌
//        MemberService memberService = new MemberServiceImpl();

        // AppConfig에 있는 환경설정 정보들을 스프링 빈에 등록하고 관리해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 이름은 memberService, 타입은 MemberService.class인 빈을 호출
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // 이제 appconfig에서 전부다 결정
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        // ctrl + alt + v -> 저장할 객체와 변수를 추천
        // 회원 가입
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // 회원 조회
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}

// 순수한 자바 코드로만 개발한 것
