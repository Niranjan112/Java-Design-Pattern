package designpattern.behavioral.chainofresponsibility;

/**
 * Here in this example, we are chaining multiple responsibility before payment.
 * That if the amount is less than 500 then BankPaymentHandler will process it.
 * If amount is more than 500 then BankPaymentHandler will send to next payment handler i.e CreditCardPaymentHandler.
 * If amount is more than 1000 then CreditCardPaymentHandler will send request to PayPalPaymentHandler.
 * */
abstract class PaymentHandler {
    protected PaymentHandler next;
    public void setNext(PaymentHandler next) {
        this.next = next;
    }
    public abstract void handlePayment(double amount);
}

class BankPaymentHandler extends PaymentHandler{
    public void handlePayment(double amount) {
        if (amount <= 500) {
            System.out.println("Paid using bank account: $" + amount);
        } else {
            next.handlePayment(amount);
        }
    }
}

class CreditCardPaymentHandler extends PaymentHandler{
    public void handlePayment(double amount) {
        if (amount <= 1000) {
            System.out.println("Paid using credit card: $" + amount);
        } else {
            next.handlePayment(amount);
        }
    }
}

class PayPalPaymentHandler extends PaymentHandler{
    public void handlePayment(double amount) {
        if (amount <= 1500) {
            System.out.println("Paid using PayPal: $" + amount);
        } else {
            next.handlePayment(amount);
        }
    }
}
public class ChainOfResponsibilityEx {
    public static void main(String[] args) {
        PaymentHandler bank = new BankPaymentHandler();
        PaymentHandler creditCard = new CreditCardPaymentHandler();
        PaymentHandler paypal = new PayPalPaymentHandler();
        bank.setNext(creditCard);
        creditCard.setNext(paypal);

        bank.handlePayment(600);
        bank.handlePayment(200);
        bank.handlePayment(1200);
        bank.handlePayment(600);
    }
}
