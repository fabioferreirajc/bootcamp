import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {


        ToDoList list = new ToDoList();


        list.toDoListAdd(new Item(Importance.LOW, "PAY BILLS", 1));
        list.toDoListAdd(new Item(Importance.HIGH, "STUDY", 1));
        list.toDoListAdd(new Item(Importance.MEDIUM, "SHOPPING", 2));
        list.toDoListAdd(new Item(Importance.MEDIUM, "CLEAN HOUSE", 1));

        while (!list.isEmpty()) {
            System.out.println(list.remove());
        }


    }
}
