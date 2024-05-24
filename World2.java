import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World2 extends World
{

    private int worldId = 2;
    /**
     * Constructor for objects of class World2.
     * 
     */
    public World2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        prepare();
    }

    private void prepare()
    {
        setPaintOrder(Player.class, Enemy.class, Goal.class, Goal.class, InvisibleWall.class, Floor.class);
        Floor floorInicial = new Floor();
        Floor floor = new Floor();
        Floor floor2 = new Floor();
        Floor floor3 = new Floor();
        RangerTroll rt = new RangerTroll();
        InvisibleWallRight invisibleWallRight = new InvisibleWallRight(100, 100);
        addObject(rt, 1000, 690);
        addObject(floorInicial, 1100, 300);
        addObject(floor, 200, 700);
        addObject(floor2, 600, 800);
        addObject(floor3, 1000, 800);
        addObject(invisibleWallRight,368,718);
    }

    public void addPlayer(Player player)
    {
        addObject(player, 1100, 190);
    }

    public int getWorldId()
    {
        return worldId;
    }
}
