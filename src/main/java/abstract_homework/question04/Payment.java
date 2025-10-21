package abstract_homework.question04;

/**
 * 추상 클래스 Payment를 만든다.
 * 필드: double amount
 * 생성자: Payment(double amount)
 * 추상 메서드: void pay() (실제 결제 처리 로직)
 */
public abstract class Payment {

    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract void pay();
}
