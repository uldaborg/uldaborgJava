package Methods_1_2;

import java.util.ArrayList;

public class Any_Array <T> {
    private T[] my_array;

    public Any_Array(T... elems){

        this.my_array = elems;
    }

    public   void  change_elems( Integer m, Integer n) {
        T temp;

        temp = this.my_array[m];
        this.my_array[m] = this.my_array[n];
        this.my_array[n] = temp;
    }

    public T get_elem(int i){
        return this.my_array[i];
    }


    public ArrayList<T> arrayToArrayList () {

        ArrayList<T> result = new ArrayList<T>();

        for( int i = 0; i < this.my_array.length; ){
            boolean alwaysTrue = result.add( this.my_array[i] );
        }
        return result;
    }
}
