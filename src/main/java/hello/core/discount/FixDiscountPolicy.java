package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 1000원 할인
    @Override
    // f2 -> 오류난 곳으로 바로 이동
    public int discount(Member member, int price) {
        // 멤버가 vip면 할인 금액 1000원
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            // 아니라면 할인 금액 0원
            return 0;
        }
    }
}
