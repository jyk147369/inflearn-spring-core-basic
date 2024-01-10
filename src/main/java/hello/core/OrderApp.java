package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
// 더이상 구체 클래스에 의존할 필요가 없어짐
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memnerId = 1L;
        Member member = new Member(memnerId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memnerId, "itemA", 10000);

        System.out.println("order = " + order);
//        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
