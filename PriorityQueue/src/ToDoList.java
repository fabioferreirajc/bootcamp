import java.util.PriorityQueue;

public class ToDoList {

    private PriorityQueue<Item> listpq;

    public ToDoList() {
        this.listpq = new PriorityQueue();

    }

    public void toDoListAdd (Item item) {
        listpq.add(item);
    }

    public Item remove () {
        return listpq.poll();
    }


    public boolean isEmpty () {
        return listpq.isEmpty();
    }


}
