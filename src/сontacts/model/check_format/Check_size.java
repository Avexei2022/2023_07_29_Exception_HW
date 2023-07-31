package сontacts.model.check_format;

import сontacts.model.exception_app.ItemCountException;

public class Check_size {

    public boolean check_size (String [] input_array){
        if (input_array.length == 6) {
            return true;
        } else {
            if (input_array.length < 6) {
                throw new ItemCountException("Вы ввели данных - " + input_array.length + ", это меньше необходимого количества.");
            } else {
                throw new ItemCountException("Вы ввели данных - " + input_array.length + ", это больше необходимого количества.");
            }
        }
    }

}
