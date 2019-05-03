package Methods_1_2;

public class WorkingWithFruits {

    public static void main(String[] args) {
        Apple A         = new Apple();
        Orange O        = new Orange();
        Box bigBox      = new Box();
        Box smallBox    = new Box();
        Box emptyBox    = new Box();

        System.out.println( A.getClass().getName()) ;
        System.out.println( O.getClass().getName()) ;
//яблочки
        bigBox.addFruit(A);
        bigBox.addFruit(O);
        bigBox.addFruit(A);
        bigBox.addFruit(A);
        bigBox.addFruit(A);
//апельсинчики
        smallBox.addFruit(O);
        smallBox.addFruit(O);
        smallBox.addFruit(O);
        smallBox.addFruit(O);
        smallBox.addFruit(O);
        smallBox.addFruit(O);


        System.out.println("Яблочек = " + Box.getWeight(bigBox));
        System.out.println("Апельсинчиков = " + Box.getWeight(smallBox));
        System.out.println(Box.compare(smallBox, bigBox));

        smallBox.pourFromTo(emptyBox);
        System.out.println("Кто был пустым стал полным = " + Box.getWeight(emptyBox));
        System.out.println("А кто был полным  стал пустым = " + Box.getWeight(smallBox));

    }
}
