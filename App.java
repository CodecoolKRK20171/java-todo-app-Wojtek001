import java.util.Scanner;
import java.lang.IndexOutOfBoundsException;
import java.lang.NumberFormatException;


public class App{
    private Scanner userInput;
    private TodoList todoList;

    public App() {
        this.userInput = new Scanner(System.in);
        this.todoList = new TodoList();
    }

    private void printMenu() {
        String menu = "\nMenu:\n 1. Add item\n 2. Mark item as done\n 3. Remove all marked items\n 4. Exit";
        System.out.println(menu);
    }

    private int inputIndex() {
        String option;
        int index;

        System.out.println("\nType the item number: ");
        option = userInput.nextLine();
        index = Integer.parseInt(option) - 1;

        return index;
    }

    private String inputDescription() {
        String option;
        System.out.println("\nType the description of the new item: ");
        option = userInput.nextLine();
        return option;
    }

    private String inputChoice() {
        String option;
        System.out.println("\nChoose selected option: ");
        option = userInput.nextLine();
        return option;
    }

    private void addItem() {

        String content = this.inputDescription();
        this.todoList.addItem(new TodoItem(content));
    }

    private void markItem() {

        int index = this.inputIndex();
        this.todoList.itemList.get(index).markAsDone();
    }

    private void save() {
        for (int i = this.todoList.itemList.size() - 1; i > -1; i--) {

            if (this.todoList.itemList.get(i).getIsDone()) {
                this.todoList.itemList.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        boolean exit = false;
        String option;
        App application = new App();

        while (!exit) {
            System.out.println(application.todoList.getStringTodoList());
            application.printMenu();

            option = application.inputChoice();
            switch(option) {
                case "1":
                    application.addItem();
                    break;

                case "2":

                try {
                    application.markItem();
                } catch (IndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Wrong number! Type correct number of selected item!");
                }

                    break;

                case "3":
                    application.save();
                    break;

                case "4":
                    exit = true;
                    break;

                default:
                    System.out.println("There is no such option!");
                    break;
            }
        }
    }
}