package MainCourse;

public class Cat extends Creature {

    public Cat(String name, int age, int rl, int jl){

        super.runLimit = rl;
        super.jumpLimit = jl;
        super.name = name;
        super.age = age;
        super.swimLimit = 0;

    }
}
