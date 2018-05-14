class NotString {

    public static void main(String[] args) {

        notString("semicolon");
        notString("not semicolon");

        //receive command line argument if available
        if(args.length>0){
            notString(args[0]);
        }

    }

    private static void notString(String str) {


        String n = str.substring(0,3);
        String not="not";
        //System.out.println(n);

        if (n.equals(not)) {System.out.println(str);}
        else {System.out.println(str+" not");}

    }

}
