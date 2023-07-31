package сontacts.model;

import сontacts.model.check_format.Checking_service;

import сontacts.model.exception_app.ThisAppException;

public class Service {
    private File_using file_using;
    private Checking_service checking_service;
    String userString;

    public Service(){
        file_using = new File_using();
        this.userString = "";
        checking_service = new Checking_service("");
    }

    public void get_user_data(String userString) throws ThisAppException {
        checking_service.get_array(userString);

    }


}
