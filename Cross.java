package MainCourse;

public class Cross extends Obstacle {

    private int distance;

    public Cross(int height){  this.distance = height; }

    public boolean tryIt (Participant participant){

        return participant.Run(this.distance);

    }
}