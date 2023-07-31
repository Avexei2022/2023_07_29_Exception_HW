package сontacts.model.check_format;

public class Check_letter {
    public boolean check_letter(String string){
        try{
            return string.matches("\\p{L}*");
        } catch (NullPointerException e) {
            return false;
        }
    }

}
