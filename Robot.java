package MainCourse;

public class Robot extends Creature {

    public Robot(String name, int age, int rl, int jl, int sl) {

        super.runLimit = rl;
        super.jumpLimit = jl;
        super.name = name;
        super.age = age;
        super.swimLimit = sl;

    }
}
