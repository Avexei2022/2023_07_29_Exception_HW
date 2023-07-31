package сontacts.model.check_format;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Check_date {
    DateTimeFormatter formatter;
    public Check_date(){
        formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    }

    public boolean check_date(String string){
        try {
            LocalDate.parse(string, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
