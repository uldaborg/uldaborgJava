package MainCourse;

public class Pool extends Obstacle {

    private int distance;

    public Pool(int distance){  this.distance = distance; }

    public boolean tryIt (Participant participant){

        return participant.Swim(this.distance);

    }
}