package MainCourse;

public class Team {

    private Participant[] players;

    public Team(Participant... players){

        this.players = players;
    }

    public Participant[] getPlayers() {
        return players;
    }

}
