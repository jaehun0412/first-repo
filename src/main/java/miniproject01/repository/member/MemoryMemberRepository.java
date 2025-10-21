package miniproject01.repository.member;

import miniproject01.dto.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private Map<Long, Member> memberMap;

    public MemoryMemberRepository() {
        memberMap = new HashMap<>();
    }

    @Override
    public void save(Member member) {
        memberMap.put(member.getMemberId(), member);
    }

    @Override
    public List<Member> findAll() {
        return memberMap.values().stream().toList();
    }

    @Override
    public List<Member> findByName(String name) {
        return memberMap.values().stream()
                .filter(member -> member.getName().equalsIgnoreCase(name))
                .toList();
    }

    @Override
    public Member findById(Long memberId) {
        return memberMap.get(memberId);
    }

    @Override
    public boolean isEmpty() {
        return memberMap.isEmpty();
    }
}
