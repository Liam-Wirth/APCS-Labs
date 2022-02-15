import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
 public class quickCrab extends CrabCritter {

    //null constructor that defaults to using magenta
    public quickCrab() {
        setColor(Color.MAGENTA);
    }

    /**
     * Allows the user to set a color.
     */
    public quickCrab(Color c){
        setColor(c);
    }

    /* (non-Javadoc)
     * @see CrabCritter#getLocationsInDirections(int[])
     */
    @Override
    /**
     * Finds the valid adjacent locations of this critter in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @return a set of valid locations that are neighbors of the current
     * location in the given directions, extended two places.
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();

        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            Location moveToLoc = neighborLoc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc) && gr.isValid(moveToLoc) && gr.get(neighborLoc) == null && gr.get(moveToLoc) == null)
                locs.add(moveToLoc);
        }
        if(locs.size() == 0)
            return super.getLocationsInDirections(directions);
        else
            return locs;
    }

     public static void main(String[] args)
     {
         ActorWorld world = new ActorWorld();
         world.add(new Location(7, 5), new Rock());
         world.add(new Location(5, 4), new Rock());
         world.add(new Location(5, 7), new Rock());
         world.add(new Location(7, 3), new Rock());
         world.add(new Location(7, 8), new Flower());
         world.add(new Location(2, 2), new Flower());
         world.add(new Location(3, 5), new Flower());
         world.add(new Location(3, 8), new Flower());
         world.add(new Location(6, 5), new Bug());
         world.add(new Location(5, 3), new Bug());
         world.add(new Location(4, 5), new CrabCritter());
         world.add(new Location(6, 1), new CrabCritter());
         world.add(new Location(7, 4), new quickCrab());
         world.show();
     }
 }


