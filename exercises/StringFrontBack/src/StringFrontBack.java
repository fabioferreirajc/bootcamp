public class StringFrontBack {

    public static void main(String[] args) {

        frontBack("heisenberg");

        //receive command line argument if available
        if(args.length>0){
            frontBack(args[0]);
        }
    }

    private static void frontBack(String str) {

        char last = str.charAt(str.length()-1);
        char first = str.charAt(0);
        System.out.println(last + str.substring(1, str.length()-1)+first);
    }
}
