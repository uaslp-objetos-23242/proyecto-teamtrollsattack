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
    public PlaceHolderBG()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Floor floor = new Floor();
        addObject(floor,241,339);
        floor.setLocation(452,391);
        floor.setLocation(434,398);
        Player player = new Player();
        addObject(player,31,369);
    }
}
