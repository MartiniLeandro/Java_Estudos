package Exceptions;

import java.lang.RuntimeException;

public class LoginInvalidoException extends RuntimeException {
    public LoginInvalidoException(String msg){
        super(msg);
    }
}
