package Methods_1_2;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    String typeOfFruit;
    Integer quantity;
    ArrayList<T> content;

    public Box() {
        this.typeOfFruit = null;
        this.quantity = 0;
        this.content = new ArrayList<T>();
    }

    public Fruit getFruit () {

        return this.content.get(this.quantity - 1 );
    }


    public Box addFruit(T f) {

        if (this.quantity == 0) {
            this.typeOfFruit = f.getClass().getName(); }
         else {
            if (this.typeOfFruit != f.getClass().getName()) {
                System.out.println( "Не то суете в коробку!" );
                return this; }}

            boolean alwaysTrue = this.content.add( f );
            this.quantity++;
            return this;
    }
        public static double getWeight (Box box){
            double theWeight = 0;

            if(box.typeOfFruit == "Methods_1_2.Apple") { System.out.println("A");
                theWeight = Apple.weight;}

            if(box.typeOfFruit == "Methods_1_2.Orange"){ System.out.println("O");
                theWeight = Orange.weight;}

            return box.quantity * theWeight;
        }

        public static boolean  compare(Box b1, Box b2){
            return( getWeight(b1) ==  getWeight(b2) ) ? true  : false;
        }

        public  void pourFromTo(Box b2){
                System.out.println( this.quantity );
            if( this.typeOfFruit !=  b2.typeOfFruit && b2.quantity != 0){
                System.out.println( "Нельзя так делать!" );
                return;
            }
            for (int i = this.quantity - 1; i >= 0; i-- ){
                b2.addFruit( this.getFruit() );
                this.content.remove(i);
                this.quantity--;
            }
        }

}