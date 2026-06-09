package smart_payment_system;

public class PaymentFactory {

    // java does not allow standalone methods in empty space. Every method MUST be inside a class.
    // So, we created this 'PaymentFactory' class just to hold our method.

    private PaymentFactory() {}//every class HAS TO have at least one constructor(we wrote it because we want to make it private)


    //we don t know the return type if its CyrptoProcessor or paypalProcessor or CredditCardProcessor;
    //but we know that all this types are implement PaymentProcessor interface. 
    //so we wrote PaymentProcesor as the return type    
    public static PaymentProcessor createProcessor(String type) throws IllegalArgumentException{
    //we make it static because when we want to create this object, we don t have to create a PaymentFactory object.
    //We make this method 'static' so we can call it directly using the class name
    
    
        if (type == null) {
            throw new IllegalArgumentException("Payment type cannot be null");
        }
            
        switch (type.toLowerCase().trim()) {//in case user wrote with uppercase
            case "credit":
                return new CreditCardProcessor();
            case "paypal":
                return new PayPalProcessor();
            case "crypto":
                return new CryptoProcessor();
            default:
                // if the user wrote a unknown type we throw a exception
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }
}
