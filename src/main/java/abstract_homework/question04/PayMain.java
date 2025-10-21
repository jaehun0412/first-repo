package abstract_homework.question04;

/**
 * main 메서드에서 다양한 Payment 객체를 생성하여 pay()를 호출해본다.
 */
public class PayMain {

    public static void main(String[] args) {
        CardPayment cardPayment = new CardPayment(10000);
        PaypalPayment paypalPayment = new PaypalPayment(5000);

        cardPayment.pay();
        paypalPayment.pay();
    }
}
