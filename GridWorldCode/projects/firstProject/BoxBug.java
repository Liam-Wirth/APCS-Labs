import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class BoxBug extends Bug {
    private int steps;
    private int sideLength;

    /**
     * Constructs a box bug that traces a square of a given side length
     *
     * @param length the side length
     */
    public BoxBug(int length) {
        steps = 0;
        sideLength = length;
    }

    /**
     * Moves to the next location of the square.
     */
    public void act() {
        if (steps < sideLength && canMove()) {
            move();
            steps++;
        } else {
            turn();
            turn();
            steps = 0;
        }
    }

    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        boxBug alice = new boxBug(6);
        world.add(new Location(7, 8), alice);
        world.show();
    }
}
