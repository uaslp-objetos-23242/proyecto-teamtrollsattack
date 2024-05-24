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
    private int worldId = 1;
    Player player = new Player();
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
        setPaintOrder(Player.class, Enemy.class, Goal.class, InvisibleWall.class, Floor.class);
        Floor floor = new Floor();
        Floor floor2 = new Floor();
        Floor floor3 = new Floor();
        Floor floor4 = new Floor();
        TrollGeneral tg = new TrollGeneral();
        addObject(tg, 1000, 690);
        addObject(floor, 200, 800);
        addObject(floor2, 600, 800);
        addObject(floor3, 1000, 800);
        addObject(floor4, 200, getHeight()/2);
        addObject(player, 200, getHeight()/2 - 110);
    }
    
    public void addPlayer(Player player)
    {
        addObject(player, 50, 50);
    }
    
    public void addControl(MainMenuButtons mmb)
    {
        addObject(mmb, 0, 0);
    }
    
    public int getWorldId()
    {
        return worldId;
    }
}
