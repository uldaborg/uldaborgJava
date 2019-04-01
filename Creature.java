package MainCourse;

public class Creature implements Participant {

    String      name;
    Integer     age;
    Integer     runLimit;
    Integer     swimLimit;
    Integer     jumpLimit;

    public String getName() { return name; }

    public Integer getAge() { return age;  }

    public Integer getRunLimit() { return runLimit;  }

    public Integer getSwimLimit() { return swimLimit; }

    public Integer getJumpLimit() { return jumpLimit; }


    public boolean Run(int distance){
        int limit = this.getRunLimit();
        if(limit == 0 ){ System.out.println(this.getName() + ": не умею бегать. Сошел с дистанции..."); return false; }
        if( !checkLimit( limit, distance) ) return false;

        if (distance <= limit) {System.out.println(this.getName() + ": смог пробежать..." + distance + " метров"); return true; }
        else { System.out.println(this.getName() + ": не cмогу я столько пробежать: " + distance + " метров. Сошел с дистанции..."); return false; }
    }

    public boolean Swim(int distance){
        int limit = this.getSwimLimit();
        if(limit == 0 ){ System.out.println(this.getName() + ": не умею плавать. Сошел с дистанции..."); return false; }
        if( !checkLimit( limit, distance) )  return false;

        if (distance <= limit) {System.out.println(this.getName() + ": проплыл целых " + distance + " метров");return true;  }
        else {System.out.println(this.getName() + ": не смогу я столько проплыть: "+ distance + " метров. Сошел с дистанции..."); return false; }}

    public boolean Jump(int height){
        int limit = this.getJumpLimit();
        if(limit == 0 ){ System.out.println(this.getName() + ": не умею прыгать. Сошел с дистанции..."); return false; }
        if( !checkLimit( limit, height) ) return false;

        if (height <= limit) { System.out.println(this.getName() + ": смог прыгнуть на целых " + height + " метра"); return true; }
        else { System.out.println(this.getName() + ": не cмогу так высоко прыгнуть: " + height + " метров. Сошел с дистанции..."); return false; } }

    public boolean checkLimit(int limit, int req) {
        if(req <= 0) { System.out.println(this.getName() + ": стою на месте. Сошел с дистанции..."); return false;}
        else return true;
    }

}
