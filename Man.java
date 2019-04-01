package MainCourse;

public class Man extends Creature {

        public Man(String name, int age, int rl, int jl, int sl) {

            super.runLimit = rl;
            super.jumpLimit = jl;
            super.name = name;
            super.age = age;
            super.swimLimit = sl;

        }
}

