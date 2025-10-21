package abstract_homework.question04;

/**
 * Payment를 상속받는 CardPayment, PaypalPayment 클래스를 만든다.
 * PaypalPayment의 pay() 메서드: "PayPal로 amount 원 결제하였습니다." 출력
 */
public class PaypalPayment extends Payment {

    public PaypalPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("PayPal로 " + amount + "원 결제하였습니다.");
    }
}
