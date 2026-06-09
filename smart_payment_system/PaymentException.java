package smart_payment_system;

public class PaymentException extends Exception{

    public String message;
    
    public PaymentException(String message) {
        super(message);//we send our message to upper class Exception
    }
}
