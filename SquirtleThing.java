import java.io.ObjectInputStream.GetField;

public class SquirtleThing extends PokeThing {

	int squaresMoved = 0;
	
	/**
	 * SquirtleThing Constructor
	 * Creates a new <code>SquirtleThing</code> object.
	 * Associated graphics file will be squirtle.png
	 */
	public SquirtleThing()
	{
		super("Squirtle", "", 0);	
		setImageFileType(IMAGETYPE_PNG);
	}
	
	
	/**
	 * step method -- this method is called over and over
	 * <code>SquirtleThing</code> moves in a pattern and prints how far it has gone
	 */	
	public void step()
	{
		movementPattern();
		
		Gui g = getBoard().getGui();
		squaresMoved++;
		g.appendTextWindow("Squirtle has moved " + squaresMoved + " squares.");
	}
	
	// Test
	/**
	 * movement in a repeating pattern
	 * <code>SquirtleThing</code> turns right if it is blocked or encounters a wall
	 */	
	public void movementPattern()
	{
		// Check the 'next' Location.  If there is a PokeThing or wall there, turn.
		boolean blocked;
		boolean stuck;
		boolean flower;
			
		Location nextLoc = getDirection().getNextLocation(getLocation()); 
		blocked = getBoard().thingAt(nextLoc) instanceof PokeThing;
		stuck = !(nextLoc.isValid(getBoard()));
		flower = getBoard().thingAt(nextLoc) instanceof FlowerThing;
		if (getBoard().thingAt(nextLoc) instanceof FlowerThing)
		{
			FlowerThing f = (FlowerThing) getBoard().thingAt(nextLoc);
			getBoard().remove(f);
			getBoard().getGui().appendTextWindow("FLOWER!");
		}
		if (getBoard().thingAt(nextLoc) instanceof BulbasaurThing)
		{
			if (getBoard().thingAt(nextLoc) instanceof FlowerThing)
			{
				FlowerThing f = (FlowerThing) getBoard().thingAt(nextLoc);
				getBoard().remove(f);
				getBoard().getGui().appendTextWindow("FLOWER!");
			}
			getBoard().getGui().appendTextWindow("Squirtle sees a bulbasaur!");
			setDirection(getDirection().rightHalf());
			move();
			setDirection(getDirection().left());
		}
		if (blocked)
		{
			setDirection(getDirection().right());
			Gui g = getBoard().getGui();
			g.appendTextWindow("Squirtle sees a bulbausaur!");
		} else if (stuck) {
			setDirection(getDirection().right());
			Gui g = getBoard().getGui();
			g.appendTextWindow("Stuck");
		}
	
		move();
	}
}
