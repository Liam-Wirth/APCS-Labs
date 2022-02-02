import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class circleBug extends boxBug {
    protected int steps;
    protected int length;
    public circleBug(int length) {
        super(length);
        this.length=length;
    }
    public void act()
    {
        if (steps < length && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
    }
    //circlebugrunner
    public static void main(String[] args)
    {

        ActorWorld world = new ActorWorld();
        world.add(new Location(5,1), new circleBug(2));
        world.show();
    }
}
