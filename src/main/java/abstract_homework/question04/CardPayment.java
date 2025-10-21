package abstract_homework.question04;

/**
 * Payment를 상속받는 CardPayment, PaypalPayment 클래스를 만든다.
 * CardPayment의 pay() 메서드: "신용카드로 amount 원 결제하였습니다." 출력
 */
public class CardPayment extends Payment {

    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("신용카드로 " + amount + "원 결제하였습니다.");
    }
}
