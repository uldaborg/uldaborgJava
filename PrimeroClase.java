package Lesson2;
import java.lang.Integer;
import java.lang.String;

import static java.lang.Integer.parseInt;


public class PrimeroClase {

    public static void main(String[] args){

        int summary;

        String rightArrayV0[][] = {{"1", "2", "3", "4"},
                                   {"1", "2", "3", "4"},
                                   {"1", "2", "3", "4"},
                                   {"1", "2", "3", "4"} } ;

        String wrongArrayV0[][] = {{"1", "2", "3", "4"},
                                   {"1", "А", "3", "4"},
                                   {"1", "2", "Ш", "4"},
                                   {"1", "2", "3", "А"} } ;

        String wrongArrayV1[][] = {{"1", "2", "3", "4", "5"},
                                   {"1", "2", "3", "4", "5"},
                                   {"1", "2", "3", "4", "5"},
                                   {"1", "2", "3", "4", "5"},
                                   {"1", "2", "3", "4", "5"} } ;

        try{ summary = sumUp(rightArrayV0);
             System.out.println( String.format("Сумма элементов массива = %d" , summary)) ; }
        catch (MyArraySizeException e)
              { System.out.println( String.format( "Неверный размер двумерного массива - %d. Должен быть 4x4", e.getDetails() )) ;}
        catch (MyArrayDataException e)
              { System.out.println( String.format("Неверный формат элемента [%d] [%d]. Должно быть целое число", e.getX(), e.getY() )) ;}
    }

    public static int sumUp(String[][] anyArray) throws MyArraySizeException, MyArrayDataException
    {
        int sum = 0;
        int symbol;
        int length = anyArray.length;
 //проверяем размерность массива
        if ( length != 4 ) { throw new  MyArraySizeException (length); }
            else { for( int i = 0; i < length; i++ )
                   { if ( anyArray[i].length != 4) { throw new  MyArraySizeException ( anyArray[i].length);  } }
            }

 //размер в порядке. проверяем состав сырья.
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try { symbol = parseInt(anyArray[i][j]); }
                    catch (NumberFormatException e) {
                        throw new  MyArrayDataException (i, j);
                   }
                sum = sum + symbol;
            }
        }
        return sum;
    }

}
