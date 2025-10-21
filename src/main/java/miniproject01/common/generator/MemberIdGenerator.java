package miniproject01.common.generator;

public class MemberIdGenerator {

    private static Long memberId = 1L;

    public static Long generateMemberId() {
        return memberId++;
    }
}
