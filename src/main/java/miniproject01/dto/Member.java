package miniproject01.dto;

import miniproject01.common.generator.MemberIdGenerator;

public class Member {

    private Long memberId;
    private String name;
    private String phoneNumber;
    private String birth;

    public Member(String name, String phoneNumber, String birth) {
        memberId = MemberIdGenerator.generateMemberId();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
    }

    public Member(Long memberId, String name, String phoneNumber, String birth) {
        this.memberId = memberId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "[" + memberId + "] 이름: " + name + " | 전화번호: " + phoneNumber + " | 생년월일: " + birth;
    }
}
