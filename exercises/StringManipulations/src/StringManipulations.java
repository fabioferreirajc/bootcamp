public class StringManipulations {



    public static void main(String[] args) {



        String str = "http://www.academiadecodigo.org";

        String domain = str.substring(7,str.length()); // www.academiadecodigo.org

        String academia= str.substring(11,19);
            academia=academia.substring(0, 1).toUpperCase() + academia.substring(1);

        String de= str.substring(19,21);

        String codigo= str.substring(21,27);
            codigo=codigo.substring(0, 1).toUpperCase() + codigo.substring(1);

        String name = academia +" "+ de +" " + codigo;   // < Academia de Codigo_ >


        System.out.println("I am a Code Cadet at " + "< " + name +"_ >, " + domain );


    }
}
