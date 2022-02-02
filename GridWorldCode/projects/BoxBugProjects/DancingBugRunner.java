import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class DancingBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
	int[] a = {5, 3, 6, 9, 4, 4};
        DancingBug alice = new DancingBug(a);
        alice.setColor(Color.ORANGE);
	int[] b = {10, 2, 4, 3, 7, 8};
        DancingBug bob = new DancingBug(b);
        world.add(new Location(7, 8), alice);
        world.add(new Location(5, 5), bob);
        world.show();
    }
}
