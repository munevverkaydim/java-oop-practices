package smart_payment_system;

public class PayPalProcessor implements PaymentProcessor{
    
    @Override
    public void processPayment(double amount) throws PaymentException{
        
        if(amount < 10){
            throw new PaymentException("PayPal requires a minimum payment of 10");
        }

        System.out.println("Processing PayPal payment of " + amount);

    }
}
