package Lesson2;

public class MyArraySizeException  extends Exception {

    int size;

    public MyArraySizeException( int size ){

        this.size =  size;
    }

    public int getDetails() {
        return size;
    }
}
