import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World6 extends World
{

    /**
     * Constructor for objects of class World6.
     * 
     */
    private int worldId = 6;
    public World6()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Player.class, Enemy.class, Goal.class, Goal.class, InvisibleWall.class, Floor.class);
        Floor floorInicial = new Floor();
        Floor floor = new Floor();
        Floor floor2 = new Floor();
        Floor floor3 = new Floor();
        Floor floor4 = new Floor();
        TrollGeneral trollGeneral = new TrollGeneral();
        MountainTroll mountainTroll = new MountainTroll();
        addObject(floorInicial, 200, 800); 
        addObject(floor, 50, 300);
        addObject(floor2, 600, 700);
        addObject(floor3, 1000, 600);
        addObject(floor4, 500, 450);
        addObject(trollGeneral,1019,476);
        addObject(mountainTroll,492,314);
        InvisibleWallLeft invisibleWallLeft = new InvisibleWallLeft(100, 100);
        addObject(invisibleWallLeft,435,705);
        InvisibleWallLeft invisibleWallLeft2 = new InvisibleWallLeft(100, 100);
        addObject(invisibleWallLeft2,835,605);
        InvisibleCeiling invisibleCeiling = new InvisibleCeiling(400, 40);
        addObject(invisibleCeiling,492,455);
        InvisibleWallRight invisibleWallRight = new InvisibleWallRight(25, 55);
        addObject(invisibleWallRight,680,435);
        InvisibleWallLeft invisibleWallLeft3 = new InvisibleWallLeft(25, 55);
        addObject(invisibleWallLeft3,305,435);
        InvisibleWallRight invisibleWallRight2 = new InvisibleWallRight(100, 100);
        addObject(invisibleWallRight2,213,311);
    }

    public void addPlayer(Player player)
    {
        addObject(player, 200, 690);
    }

    public int getWorldId()
    {
        return worldId;
    }
}
