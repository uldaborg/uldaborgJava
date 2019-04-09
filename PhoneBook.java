package Lesson3;

import java.util.*;
import java.util.HashSet;

public class PhoneBook extends HashMap {


    class Phones extends HashSet{

        public Phones(){
            new HashSet<String>();  }
    }

    PhoneBook(){

        new HashMap< String, Phones  > ();
    }

    public Phones getPhones(String name){

        Phones answer = new Phones();
            answer = (Phones) this.get( name);
                return  answer;
    }

    public void add (String name, String phoneNum){

        Phones p = new Phones();

        if( this.containsKey(name) ) {
            p = this.getPhones(name);
                p.add(phoneNum);
                    this.put( name, p);
        }
        else{
            this.put( name , new Phones() );
                p = this.getPhones(name);
                    p.add(phoneNum);
                        this.put( name, p);
        }
    }

}
