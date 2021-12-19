package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {
//  private final MemberRepository memberRepository = new MemoryMemberRepository();
  private final MemberRepository memberRepository;

  @Autowired // 마치 ac.getBean(MemberRepository.class)을 자동으로 입력해준 것처럼 처럼 매개변수에 주입"받아"
  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }

  //Test 용도
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
