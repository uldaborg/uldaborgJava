package Lesson3;

import java.util.*;

public class Lesson3Main {

        public static void main (String[] args) {

            String[] elems = {"A","L", "E","J","A","N","D","R","O",
                              "mas","siete","nueve","ocho","cinco","siete","dos","siete","cinco","uno","nueve","uno"};

            int elemsLen = elems.length;

            HashMap<String, Integer> uniqueList = new HashMap<>(elemsLen);
//формируем уникальный список с числом вхождений
            for (String e : elems ){
              uniqueList.putIfAbsent(e , 0);
                uniqueList.put(e , uniqueList.get(e) + 1);
            }
//печатаем уникальный список с числом вхождений
            for(Map.Entry<String, Integer> e : uniqueList.entrySet()) {
              System.out.println("количество вхождений " + e.getKey() + " = " + e.getValue()) ;
            }

            System.out.println("--------ТЕПЕРЬ ИГРИЩА С ТЕЛЕФОННОЙ КНИГОЙ") ;
//создаем книгу
            PhoneBook myBook = new PhoneBook();
//заполняем
            myBook.add("Ivanov",      "112");
            myBook.add("Ivanov",      "001");
            myBook.add("Ivanov",      "002");

            myBook.add("Vovanov",     "666");

            myBook.add("Gubanov",     "112");
            myBook.add("Gubanov",     "113");
//проверяем
            System.out.println("Телефоны человека по фамилии " + "Gubanov");
            System.out.println(myBook.getPhones("Gubanov"));

            System.out.println("Телефоны человека по фамилии " + "Ivanov");
            System.out.println(myBook.getPhones("Ivanov"));

            System.out.println("Телефоны человека по фамилии " + "Vovanov");
            System.out.println(myBook.getPhones("Vovanov"));
        }
}


