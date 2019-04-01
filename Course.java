package MainCourse;

public class Course {

    private Obstacle[] obstacles;
    public Boolean     canDoIt;

    public Course(Obstacle... obstacles){ this.obstacles = obstacles; }

    public boolean tryIt(Team team) {
        for(Participant player : team.getPlayers()){
            for(Obstacle obstacle : obstacles) { canDoIt = obstacle.tryIt(player); if (!canDoIt) break;}
        }
    return true;
    }
}
