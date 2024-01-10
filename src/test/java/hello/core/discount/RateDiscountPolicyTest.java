package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
        // alt + enter -> on-demand static ~ 클릭 -> static import, 더 간결한 코드를 사용할 수 있다.
    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인이 적용되지 않아야 한다.")
    void vip_x(){
        //given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);
        //then
//        Assertions.assertThat(discount).isEqualTo(1000);
        assertThat(discount).isEqualTo(0);

    }


}