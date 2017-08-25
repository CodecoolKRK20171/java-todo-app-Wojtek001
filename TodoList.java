import java.util.ArrayList;

public class TodoList{

    public ArrayList<TodoItem> itemList;

    public TodoList(){
        this.itemList = new ArrayList<>();
    }

    public void addItem(TodoItem item){
        this.itemList.add(item);
    }

    public void removeItem(int index){
        this.itemList.remove(index);
    }

    public String getStringTodoList(){
        String result = "\nItems to do: \n";
        int index = 1;

        for (TodoItem item: this.itemList) {
            result += String.format("%d. ", index);

            if (item.getIsDone()) {
                result += "[X] ";
            }

            result += String.format("%s%n", item.getName());
            index++;
        }
        return result;
    }
}