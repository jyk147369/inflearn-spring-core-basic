package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    // DIP 위반
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 추상에만 의존하도록 변경
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // OrderServiceImpl 입장에서는 FixDiscountPolicy가 들어올지 RateDiscountPolicy가 들어올지 모른다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        // discount 문제가 발생하면 discount 쪽만 바꾸면 된다.
        // discountPolicy가 없었다면 OrderService를 바꿔야 한다.
        // 단일 체계 원칙을 잘 지킨 것
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
