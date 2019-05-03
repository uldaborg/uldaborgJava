package Methods_1_2;

public class Methods_1_2 {

    public static void main(String[] args) {

        Any_Array<Integer> int_array = new Any_Array<>( 1, 2, 3, 4, 5, 6, 7 );
        Any_Array<String> str_array = new Any_Array<>( "A", "B", "C", "D", "E", "F", "G", "H" );

        String[] u = { "A", "B", "C", "D", "E", "F", "G", "H" };


        System.out.println(int_array.get_elem(3));
        System.out.println(int_array.get_elem(5));
        int_array.change_elems( 3, 5 );
        System.out.println(int_array.get_elem(3));
        System.out.println(int_array.get_elem(5));

        System.out.println(str_array.get_elem(3));
        System.out.println(str_array.get_elem(5));
        str_array.change_elems( 3, 5 );
        System.out.println(str_array.get_elem(3));
        System.out.println(str_array.get_elem(5));



}}