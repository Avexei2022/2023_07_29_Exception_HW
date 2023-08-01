package сontacts.model.check_format;

import сontacts.model.exception_app.*;

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
    StringBuilder sb_temp;
    public Checking_service(String string_to_check){
        this.string_to_check = string_to_check;
        check_size = new Check_size();
        check_gender = new Check_gender();
        check_phone = new Check_phone();
        check_date = new Check_date();
        check_letter = new Check_letter();
        input_array = new String[1];
        result_array = new String[6];
        sb_temp = new StringBuilder();
    }

    public String get_result_string(String string_to_check){
        input_array = string_to_check.trim().split("\\s+");

        if (!check_size.check_size(input_array)) {
            throw new ThisAppException("Ошибка: ");
        }
        Arrays.fill(result_array, null);
        check_for_index_3_5();
        check_for_index_0_2();
        if (!check_result()) {
            throw new NullValueException(sb_temp.toString());
        } else {
            sb_temp.setLength(0);
            for (String s: result_array){
                sb_temp.append("<").append(s).append(">");
            }
            sb_temp.append("\n");
            return sb_temp.toString();
        }
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

    private boolean check_result() {
        boolean flag = true;
        sb_temp.setLength(0);
        sb_temp.append("Вы не ввели:\n");
        for (int i = 0; i < result_array.length; i++){
            if (result_array[i] == null){
                switch (i) {
                    case 0 -> sb_temp.append("- фамилию\n");
                    case 1 -> sb_temp.append("- имя\n");
                    case 2 -> sb_temp.append("- отчество\n");
                    case 3 -> sb_temp.append("- дату рождения\n");
                    case 4 -> sb_temp.append("- номер телефона\n");
                    case 5 -> sb_temp.append("- пол\n");
                }
                flag = false;
            }
        }
        return flag;
    }

}
