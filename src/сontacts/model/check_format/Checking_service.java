package сontacts.model.check_format;

import сontacts.model.exception_app.ThisAppException;

import java.util.Arrays;

public class Checking_service {

    String string_to_check;
    Check_size check_size;
    Check_gender check_gender;
    Check_phone check_phone;
    Check_date check_date;
    Check_letter check_letter;
    String[] input_array;
    String[] result_array;
    public Checking_service(String string_to_check){
        this.string_to_check = string_to_check;
        check_size = new Check_size();
        check_gender = new Check_gender();
        check_phone = new Check_phone();
        check_date = new Check_date();
        check_letter = new Check_letter();
        input_array = new String[1];
        result_array = new String[6];
    }

    public String[] get_array(String string_to_check){
        input_array = string_to_check.trim().split("\\s+");

        if (!check_size.check_size(input_array)) {
            throw new ThisAppException("Ошибка: ");
        }
        for(int i = 0; i < result_array.length; i++) {
            result_array[i] = null;
        }
        check_for_index_3_5();
        check_for_index_0_2();

        System.out.println("input: " + Arrays.toString(input_array));
        System.out.println("result : " + Arrays.toString(result_array));
        return result_array;
    }

    private void check_for_index_3_5(){
        for (int i = 0; i < input_array.length; i++) {
            if (check_gender.check_gender(input_array[i])) {
                result_array[5] = input_array[i];
                input_array[i] = null;
            }
            if (check_phone.check_phone(input_array[i])) {
                result_array[4] = input_array[i];
                input_array[i] = null;
            }
            if (check_date.check_date(input_array[i])) {
                result_array[3] = input_array[i];
                input_array[i] = null;
            }
        }
    }

    private void check_for_index_0_2(){
        for (int i = 0, j = 0; i < input_array.length && j < 3; i++) {
            if (check_letter.check_letter(input_array[i])) {
                result_array[j] = input_array[i];
                input_array[i] = null;
                j++;
            }
        }
    }

}
