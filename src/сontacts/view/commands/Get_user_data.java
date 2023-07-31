package сontacts.view.commands;

import сontacts.view.ConsoleUI;

public class Get_user_data extends Command{

    public Get_user_data(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Ввод новой записи;";
    }
    public void execute() {
        consoleUI.get_user_data();
    }

}
