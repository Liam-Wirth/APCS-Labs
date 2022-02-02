import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

import java.awt.*;

public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private int moveCount = 0;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
	while (getDirection() != 90)
	    turn();
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
	if (moveCount < sideLength*3) {
	    if (steps < sideLength) {
		move();
		steps++;
		moveCount++;
	    }
	    else if (getDirection() == 90) {
		turn();
		turn();
		turn();
		steps = 0;
	    }
	    else {
		turn();
		turn();
		turn();
		turn();
		turn();
		steps = 0;
	    }
	}
    }
	//this is the zbug
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		ZBug bob = new ZBug(3);
		world.add(new Location(5, 5), bob);
		world.show();
	}
}

