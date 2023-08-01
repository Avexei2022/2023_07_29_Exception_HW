package сontacts.presenter;

import сontacts.model.Service;
import сontacts.model.exception_app.ItemCountException;
import сontacts.model.exception_app.ThisAppException;
import сontacts.view.View;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    public void get_user_data(String userString){
        try {
            service.service_run(userString);
            view.printAnswer("Новый контакт успешно записан в файл.\n");
        } catch (ThisAppException e){
            view.printAnswer(e.getMessage());

        }
    }
}
