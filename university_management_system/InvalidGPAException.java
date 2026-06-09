    // we created here for catch the invalid grade. we created with  exception class for controlled.
    //Exception class is a java class. we did nt create from zero. we used it with inheritance.
    public class InvalidGPAException extends Exception {
        
        //it  sends the error message to up classes constructor (exception)
        public InvalidGPAException(String message) {
            super(message);
        }
    }