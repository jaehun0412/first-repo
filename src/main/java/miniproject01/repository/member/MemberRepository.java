package miniproject01.repository.member;

import miniproject01.dto.Member;

import java.util.List;

public interface MemberRepository {

    void save(Member member);

    List<Member> findAll();

    List<Member> findByName(String name);

    Member findById(Long memberId);

    boolean isEmpty();
}
