package MainCourse;

public class Wall extends Obstacle {

    private int height;

    public Wall(int height){  this.height = height; }

    public boolean tryIt (Participant participant){

        return participant.Jump(this.height);

    }
}
