public class Main {

    public static void main(String[] args) {


        RangeList rangeList = new RangeList(1, 5);

        rangeList.setOrder(true);

        for (Integer number : rangeList) {
            System.out.println(number);
        }

        rangeList.setOrder(false);

        for (Integer number : rangeList) {
            System.out.println(number);
        }


    }
}
