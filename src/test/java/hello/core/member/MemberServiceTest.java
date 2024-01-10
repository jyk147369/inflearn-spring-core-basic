package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Test 밑에 있는 파일들은 운영환경에서 빠지고 배포가 됨
// Test 코드 돌려볼때 사용
public class MemberServiceTest {
    @BeforeEach
    public void beforeEach(){
        // 메소드 실행전에 appconfig부터 만든다
        AppConfig appConfig = new AppConfig();
        // 그 다음에 memberService 할당
        memberService = appConfig.memberService();
    }


    MemberService memberService;

    @Test
    void join(){
        // given : ~이 주어졌을때
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when : ~했을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
//        Member findMember = memberService.findMember(2L);

        // then : ~하게 된다
        Assertions.assertThat(member).isEqualTo(findMember);

        // join한 멤버와 find한 멤버가 같다.

    }
}
