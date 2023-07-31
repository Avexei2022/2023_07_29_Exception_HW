package сontacts.model.check_format;

public class Check_gender {
    public boolean check_gender(String string){
        return  string.equalsIgnoreCase("m") || string.equalsIgnoreCase("f");
    }
}
