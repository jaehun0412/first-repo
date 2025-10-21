package hw2.question02;

/**
 * 생성자
 * - 계좌번호와 예금주 이름을 받는 생성자
 * - 잔액은 0으로 초기화, totalAccounts 증가
 * <p>
 * 입출금 메서드
 * - deposit(double amount): 입금 (양수 금액만 허용)
 * - withdraw(double amount): 출금 (잔액 부족 시 실패)
 * - transfer(BankAccount target, double amount): 계좌 이체
 * <p>
 * 조회 메서드
 * - showBalance(): 잔액 출력
 * - showAccountInfo(): 계좌 정보 출력
 * - static showTotalAccounts(): 전체 계좌 수 출력
 * <p>
 * 비즈니스 규칙
 * 입금/출금 금액은 양수여야 함
 * 출금 시 잔액이 부족하면 실패 메시지 출력
 * 모든 거래는 성공/실패 여부를 boolean으로 반환
 */
public class BankAccount {

    private String accountNumber;
    private String name;
    private int balance;
    private static int totalAccounts;

    // 생성자
    public BankAccount(String accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
        balance = 0;
        totalAccounts++;
    }

    // 입금 메서드 (양수 금액만 허용)
    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("잘못된 금액입니다. 입금 금액은 양수만 가능합니다.");
            return;
        }
        balance += amount;
        System.out.println("입금이 완료되었습니다. " + name + " 현재 잔액: " + balance +"원");
    }

    // 출금 메서드 (잔액 부족 시 실패)
    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("잔액이 부족합니다. " + name + " 현재 잔역: " + balance+"원");
            return;
        }
        balance -= amount;
        System.out.println("출금이 완료되었습니다. " + name + " 현재 잔액: " + balance + "원");
    }

    // 계좌 이체
    public void transfer(BankAccount account, double amount) {
        if (amount < 0) {
            System.out.println("잘못된 금액입니다. 이체 금액은 양수만 가능합니다.");
            return;
        }
        if (balance < amount) {
            System.out.println("잔액이 부족합니다. " + name + " 현재 잔역: " + balance+"원");
            return;
        }
        balance -= amount;
        account.balance += amount;
        System.out.println("이체가 완료되었습니다. 내 잔액: " + balance + "원 " + account.name + "의 잔액: " + account.balance + "원");
    }

    // 잔액 출력
    public void showBalance() {
        System.out.println("현재 잔액: " + balance+"원");
    }

    // 계좌 정보 출력
    public void showAccountInfo() {
        System.out.printf("예금주 이름: %s, 계좌번호: %s, 잔액: %d원\n", name, accountNumber, balance);
    }

    // 전체 계좌 수 출력
    public static void showTotalAccounts() {
        System.out.println("전체 계좌 수: " + totalAccounts);
    }
}
