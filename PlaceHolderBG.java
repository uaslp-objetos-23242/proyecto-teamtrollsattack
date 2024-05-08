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
        super(1400, 900, 1); 
        //getBackground().scale(getBackground().getWidth()/2, getBackground().getHeight()/2);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,getWidth()/2,getHeight()/2 - 50);
        Floor floor = new Floor();
        addObject(floor, getWidth()/2, getHeight()/2);
        Floor floor2 = new Floor();
        addObject(floor2,688,744);
        PlaceHolderEnemy placeHolderEnemy = new PlaceHolderEnemy();
        addObject(placeHolderEnemy,573,692);
    }
}
