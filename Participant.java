package MainCourse;

public interface Participant {

    public boolean Run(int Distance);

    public boolean Jump(int Height);

    public boolean Swim(int Distance);

    public boolean checkLimit(int limit, int req);

}
