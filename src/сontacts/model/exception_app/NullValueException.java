package сontacts.model.exception_app;

public class NullBirthdayException extends ThisAppException{
    public NullBirthdayException (String message) {
        super(message + "\n");
    }
}
