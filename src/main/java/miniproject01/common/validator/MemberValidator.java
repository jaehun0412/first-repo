package miniproject01.common.validator;

import miniproject01.dto.Member;
import miniproject01.repository.member.MemberRepository;

public class MemberValidator {


    // 회원 등록 검증
    // TODO: 더 많은 예외 상황 검증
    public static void isValidMember(Member member) {
        if (member.getName() == null || member.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
        if (member.getPhoneNumber() == null || member.getPhoneNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("전화번호는 공백일 수 없습니다.");
        }
        if (member.getBirth() == null || member.getBirth().trim().isEmpty()) {
            throw new IllegalArgumentException("생년월일은 공백일 수 없습니다.");
        }
    }

    // TODO: 회원 검색 검증
    public static void searchValid(MemberRepository memberRepository, String searchName) {
        if (memberRepository.isEmpty()) {
            throw new RuntimeException("등록된 회원이 없습니다.");
        }

        if (searchName == null || searchName.trim().isEmpty()) {
            throw new IllegalArgumentException("공백으로 검색할 수 없습니다.");
        }
    }
}
