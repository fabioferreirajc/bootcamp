class ClosestNeighbours {
public static void main(String[] args) {

        int[] myArray = {0, 5, 1209, 6, 2, 111, 112, 33};
        int[] result = findClosest(myArray);

        // print the elements of the resulting array
        }

private static int[] findClosest(int[] numbers) {
     // hint: remember Math.abs();

    int valoranterior = Math.abs(numbers[0]-numbers[1]);
    int index = 0;

    for(int i=1; i<numbers.length-1; i++){
        int value = Math.abs(numbers[i]-numbers[i+1]);

        if(value < valoranterior){
            valoranterior= value;
            index = i;
        }
    }

    System.out.println("index "+ index + " value " + numbers[index]);
    System.out.println("index "+ (index+1) + " value " + numbers[index+1]);

    return numbers;

    }

}