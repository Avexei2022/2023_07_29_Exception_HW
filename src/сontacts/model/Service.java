package сontacts.model;

import сontacts.model.check_format.Checking_service;

import сontacts.model.exception_app.MyFileNotFoundException;
import сontacts.model.exception_app.MyIOException;
import сontacts.model.exception_app.ThisAppException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Service {
    private Checking_service checking_service;
    String userString;
    String result_string;

    public Service(){
        this.userString = "";
        result_string = "";
        checking_service = new Checking_service("");
    }

    public void service_run(String userString) throws ThisAppException{
        get_user_data(userString);
        file_writer();
    }
    private void get_user_data(String userString) throws ThisAppException {
        result_string = checking_service.get_result_string(userString);
    }

    private void file_writer(){
        String[] input_array = result_string.trim().split("><");
        String file_name = input_array[0].substring(1) + ".txt";
        File myFile = new File(file_name);
        try(FileOutputStream outputStream = new FileOutputStream(myFile, true)){
            byte[] buffer = result_string.getBytes();
            outputStream.write(buffer);
        } catch (FileNotFoundException e) {
            throw new MyFileNotFoundException(file_name, e.fillInStackTrace().toString());
        } catch (IOException e) {
            throw new MyIOException(file_name, e.fillInStackTrace().toString());
        }
        System.out.println(result_string);
    }


}
