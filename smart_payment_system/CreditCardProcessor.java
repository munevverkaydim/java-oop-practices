package smart_payment_system;

public class CreditCardProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) throws PaymentException{//we implement paymentProccessor so we have to override
        if(amount < 5000){
            throw new PaymentException("Processing credit card payment of" + amount);
        }

        System.out.println("Processing credit card payment of " + amount);
    }
}