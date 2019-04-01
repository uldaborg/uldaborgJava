package MainCourse;

public class Dog extends Creature {

    public Dog(String name, int age, int rl, int jl, int sl) {

        super.runLimit = rl;
        super.jumpLimit = jl;
        super.name = name;
        super.age = age;
        super.swimLimit = sl;

    }
}