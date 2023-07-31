package сontacts.model.exception_app;

public class ItemCountException extends ThisAppException{
    public ItemCountException(String message) {
        super(message + "\n");
    }


}
