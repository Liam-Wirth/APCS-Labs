import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
    private int steps;
    private int[] turns;
    private int moveCount = 0;


    public DancingBug(int[] turnSize)
    {
        turns = turnSize;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act() {
	if (moveCount >= turns.length) 
	    moveCount = 0;
	for (int x = 0; x < turns[moveCount]; x++)
	    turn();
	move();
	moveCount++;
    }
}
