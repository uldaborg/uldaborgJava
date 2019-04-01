package MainCourse;

public class MainCourse {

    public static void main(String[] Args){

//создаем команду
        Team beastTeam = new Team(
               new  Cat     ("Жмурик", 1, 50,   2),
               new  Dog     ("Барбос", 5, 500,  1 , 25),
               new  Man     ("Роберт", 1, 5000, 2 , 50 ),
               new  Robot   ("Хобот",  1, 5000,    50 , 500 ),
               new  Cat     ("Стронг", 10, 5000,   20)
        );

//создаем полосу препятствий
        Course beastCourse = new Course(
                new Wall(1),
                new Cross(50),
                new Pool(3),
                new Wall(5),
                new Pool(3));

//стартуем забег
        beastCourse.tryIt(beastTeam);


    }

}
