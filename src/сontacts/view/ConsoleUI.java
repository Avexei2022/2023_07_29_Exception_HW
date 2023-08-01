package сontacts.view;

import сontacts.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {

    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private Menu menu;
    String user_string;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new Menu(this);
        user_string = "";
    }
    public void get_user_data(){
        System.out.println("""
                
                Введите следующие данные в произвольном порядке, разделенные пробелом:
                Фамилия Имя Отчество дата рождения номер телефона пол.
                
                Форматы данных:
                фамилия, имя, отчество - строки
                дата рождения - строка формата dd.mm.yyyy
                номер телефона - целое беззнаковое число без форматирования
                пол - символ латиницей f или m.
                
                Введите ваши данные:\s""");
        user_string = scanner.nextLine();
        presenter.get_user_data(user_string);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void start() {
        System.out.println("\nКНИГА КОНТАКТОВ\n");
        while (work){
            execute();
        }
    }

    public void exit() {
        work = false;
    }

    private void inputError(){
        String INPUT_ERROR = "\nВведено неверное значение\n";
        System.out.println(INPUT_ERROR);
    }

    public void finish() {
        System.out.println("\nКНИГА КОНТАКТОВ. Программа закрыта.\n");
    }

    private void execute(){
        System.out.println(menu.printMenu());
        System.out.print("Введите цифру соответствующего пункта меню: ");
        String string = scanner.nextLine();
        if (checkTextForInt(string)){
            int numCommand = Integer.parseInt(string);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String string){
        if (string.matches("[1-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        int size;
        size = menu.getSize();
        if (numCommand <= size){
            return true;
        } else {
            inputError();
            return false;
        }
    }

}
