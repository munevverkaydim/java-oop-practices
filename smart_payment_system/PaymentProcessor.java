package smart_payment_system;

public interface PaymentProcessor {
            
    public void processPayment(double amount) throws PaymentException;
}
