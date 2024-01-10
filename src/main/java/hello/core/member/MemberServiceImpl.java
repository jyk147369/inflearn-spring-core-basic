package hello.core.member;

// 구현체
public class MemberServiceImpl implements MemberService{

    // 인터페이스(역할, MemberRepository)만 가지고 있으면 nullpointerexception 발생
    // 구현 객체(구현, MemoryMemberRepository)를 선택해줘야 한다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // ctrl+shift+enter-> 끝에 ; 붙여짐
    // MemberServiceImpl 클래스는 MemberRepository와 MemoryMemberRepository 모두에게 의존하고 있다.
    // DIP 위반

    @Override
    public void join(Member member) {
        // join에서 save를 호출하면 다형성에 의해서
        // MemberRepository 인터페이스가 아니라 MemoryMemberRepository에 있는 save가 호출이 된다.
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
