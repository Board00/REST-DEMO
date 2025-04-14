package KAKRABA.REST_DEMO.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class SniperMasteryExceptionHandler
{

    @ExceptionHandler(value =  {SniperMasteryNotFoundException.class})
    public ResponseEntity<Object> handleSniperMasteryNotFoundException
            (SniperMasteryNotFoundException sniperMasteryNotFoundException)
    {
        SniperMasteryException sniperMasteryException = new SniperMasteryException
                (
                    sniperMasteryNotFoundException.getMessage(),
                    sniperMasteryNotFoundException.getCause(),
                        HttpStatus.NOT_FOUND
                );

        return new ResponseEntity<>(sniperMasteryException, HttpStatus.NOT_FOUND);
    }
}
