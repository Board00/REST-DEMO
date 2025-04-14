package KAKRABA.REST_DEMO.exception;

public class SniperMasteryNotFoundException extends RuntimeException
{

    public SniperMasteryNotFoundException(String message) {
        super(message);
    }

    public SniperMasteryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
