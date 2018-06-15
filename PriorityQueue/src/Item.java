public class Item implements Comparable<Item> {


    private String toDo;
    private Importance importance;
    private int priority;

    public Item(Importance importance, String toDo,int priority) {
        this.importance = importance;
        this.toDo = toDo;
        this.priority=priority;

    }

    @Override
    public int compareTo(Item i){
        if (this.getImportance() == i.getImportance()) {
            return Integer.compare(this.priority,i.priority);
        }
        if (this.getImportance()<i.getImportance()) {
            return 1;
        }

      return -1;

    }
    /*
    @Override
    public int compareTo(Item o) {
        (this.getImportance()).comparedTo(o.getImportance());

        if(getImportance() == o.getImportance()){
            Integer.compare(this.priority, o.priority);
        }
    }
    */
    public int getImportance() {
        return importance.getImportanceValue();
    }

    @Override
    public String toString() {
        return toDo +"  " + importance;
    }
}
