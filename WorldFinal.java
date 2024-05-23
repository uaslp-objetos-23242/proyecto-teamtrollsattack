import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldFinal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldFinal extends World
{

    /**
     * Constructor for objects of class WorldFinal.
     * 
     */
    private int worldId = 5;
    /**
     * Constructor for objects of class World2Final.
     * 
     */
    public WorldFinal()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    private void prepare()
    {
        Floor floor = new Floor();
        addObject(floor, getWidth()/2, getHeight()/2);
    }
    
    public void addPlayer(Player player)
    {
        addObject(player, getWidth()/2 - 100, getHeight()/2 - 100);
    }
    
    public int getWorldId()
    {
        return worldId;
    }
}
