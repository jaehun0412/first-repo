package miniproject01.repository.member;

import miniproject01.common.DBUtil;
import miniproject01.dto.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCMemberRepository implements MemberRepository {

    @Override
    public void save(Member member) {
        String sql = "INSERT INTO members (name, phone_number, birth) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, member.getName());
            ps.setString(2, member.getPhoneNumber());
            ps.setString(3, member.getBirth());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("회원 등록 오류 발생!");
        }
    }

    @Override
    public List<Member> findAll() {
        String sql = "SELECT * FROM members";
        List<Member> members = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Long memberId = rs.getLong("member_id");
                String name = rs.getString("name");
                String phoneNumber = rs.getString("phone_number");
                String birth = rs.getString("birth");
                members.add(new Member(memberId, name, phoneNumber, birth));
            }
        } catch (SQLException e) {
            throw new RuntimeException("회원 목록 조회 오류 발생!");
        }
        return members;
    }

    @Override
    public List<Member> findByName(String name) {
        String sql = "SELECT * FROM members WHERE name = ?";
        List<Member> membersByName = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            ps.setString(1, name);

            while (rs.next()) {
                Long memberId = rs.getLong("member_id");
                String memberName = rs.getString("name");
                String memberPhoneNumber = rs.getString("phone_number");
                String memberBirth = rs.getString("birth");

                membersByName.add(new Member(memberId, memberName, memberPhoneNumber, memberBirth));
            }
        } catch (SQLException e) {
            throw new RuntimeException("회원 검색 오류 발생!");
        }
        return membersByName;
    }

    @Override
    public Member findById(Long memberId) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
