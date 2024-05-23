import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlaceHolderBG here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlaceHolderBG extends World
{

    /**
     * Constructor for objects of class PlaceHolderBG.
     * 
     */
    private int worldId = 0;
    public PlaceHolderBG()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        //getBackground().scale(getBackground().getWidth()/2, getBackground().getHeight()/2);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        

    }
    
    public void addPlayer(Player player)
    {
        addObject(player, 50, 50);
    }
    
    public int getWorldId()
    {
        return worldId;
    }
}
