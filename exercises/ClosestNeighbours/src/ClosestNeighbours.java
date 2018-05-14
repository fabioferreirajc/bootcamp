class ClosestNeighbours {
public static void main(String[] args) {

        int[] myArray = {0, 5, 1209, 6, 2, 111, 112, 33};
        int[] result = findClosest(myArray);

        // print the elements of the resulting array
        }

private static int[] findClosest(int[] numbers) {
     // hint: remember Math.abs();

    // int test= numbers[0]-numbers[1];
    // System.out.println(Math.abs(test));
    // System.out.println(test);

    int firstn=0;
    int secdn=0;

    for(int i=0; i<numbers.length-1;i++) {
        int diffvalues=(Math.abs(numbers[i]-numbers[i+1]));
            if(diffvalues<=1){
                firstn=numbers[i];
                secdn=numbers[i+1];
                //minvalueinit=diffvalues;
                //index=i;

                System.out.println(firstn);
                System.out.println(secdn);
                //System.out.println(index);
            }

        //System.out.println(diffvalues);
    }

    return numbers;
}

}