import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World8 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World8 extends World
{

    /**
     * Constructor for objects of class World8.
     * 
     */
    private int worldId = 8;
    public World8()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        prepare();
    }

    private void prepare()
    {
        setPaintOrder(Player.class, Enemy.class, Goal.class, InvisibleWall.class, Floor.class);
        Floor floorInicial = new Floor();
        Floor floor = new Floor();
        Floor floor2 = new Floor();
        Floor floor3 = new Floor();
        MountainTroll mountainTroll = new MountainTroll();
        MountainTroll mountainTroll2 = new MountainTroll();
        MountainTroll mountainTroll3 = new MountainTroll();
        addObject(floorInicial, getWidth()/2, getHeight()/2 - 200);
        addObject(floor, 200, 800);
        addObject(floor2, 600, 800);
        addObject(floor3, 1000, 800);
        addObject(mountainTroll,560,660);
        addObject(mountainTroll2,160,660);
        addObject(mountainTroll3,1000,660);
        InvisibleWallRight invisibleWallRight = new InvisibleWallRight(25, 55);
        addObject(invisibleWallRight,806,185);
        InvisibleWallLeft invisibleWallLeft = new InvisibleWallLeft(25, 55);
        addObject(invisibleWallLeft,394,185);
    }

    public void addPlayer(Player player)
    {
        addObject(player, getWidth()/2, getHeight()/2 - 310);
    }

    public int getWorldId()
    {
        return worldId;
    }
}
