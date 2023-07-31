package сontacts.view;

import сontacts.view.commands.*;
import сontacts.view.commands.Get_user_data;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Command> commandList;



    public Menu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new Get_user_data(consoleUI));
        commandList.add(new Exit(consoleUI));

    }


    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
