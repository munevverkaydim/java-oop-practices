package smart_payment_system;

import java.util.Scanner;

public class SmartPaymentSystem {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter payment type: ");
        String type = sc.nextLine();

        System.out.print("Enter amount: ");
        double amount = 0;

        try{
            amount = Double.parseDouble(sc.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Error: Invalid number format for amount.");
            sc.close();
            return; //we r ending the program here
        }
        
        

        try {
        //we r calling the static method directly with class name (we did NOT create a object)
        PaymentProcessor processor = PaymentFactory.createProcessor(type);
        //this line is confusing but we there is details:
        //PaymentProcessor is an interface that processor type will implement
        //createProcessor method is (static) inside the PaymentFactory class
        
        processor.processPayment(amount);

        }catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            
        }catch (PaymentException e) {
            System.out.println("Error: " + e.getMessage());
            
        }finally {
            sc.close();
        }
    }
}