package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


    @Test
    void createOrder(){
        Long memnerId = 1L;
        Member member = new Member(memnerId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memnerId, "itemA", 10000);
        // 검증
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

        // 순수하게 자바 코드로 단위 테스트를 만들어 확인 검증하는 것이 중요하다

    }
}
