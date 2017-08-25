/**
 * Class representing a single todo item.
 * 
 */

public class TodoItem{

    private String name;
    private boolean isDone;

    public TodoItem(String name) {
        this.name = name;
        this.isDone = false;
    }

    public String getName() {
        return this.name;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public boolean getIsDone() {
        return this.isDone;
    }
}