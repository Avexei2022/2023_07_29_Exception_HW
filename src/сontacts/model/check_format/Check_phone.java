package сontacts.model.check_format;

public class Check_phone {
    public boolean check_phone(String string){
        try {
            Long.parseLong(string);
            return true;
        } catch (NumberFormatException е){
            return false;
        }
    }
}
