package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 공연 기획자
@Configuration
public class AppConfig {

    // ctrl + e -> 최근에 열었던 파일 목록을 보여준다.

    // 추상체는 밖에서 생성해서 넣어준다
    // 생성자를 통해서 객체가 새롭게 생성되어 들어간다.
    // 생성자 주입
    // MemberServiceImpl : 객체(배우) / MemberRepository : 추상체(상대 역할) / MemoryMemberRepository : 구현체(상대 배우)
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    // ctrl + alt + m -> 드래그한 부분을 외부 메소드로 만들어주는 Extract Method

    @Bean
    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        // OrderServiceImpl이 MemoryMemberRepository와 FixDiscountPolicy를 참조하고 -> 완성된 OrderService 객체를 반환
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }


}
