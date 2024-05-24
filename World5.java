import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World5 extends World
{

    /**
     * Constructor for objects of class World5.
     * 
     */
    private int worldId = 5;
    public World5()
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
        Floor floor4 = new Floor();
        Floor floor5 = new Floor();
        MountainTroll mountainTroll = new MountainTroll();
        TrollBoss trollBoss = new TrollBoss(false);
        addObject(floorInicial, 50, 200);
        addObject(floor, 200, 800);
        addObject(floor2, 600, 800);
        addObject(floor3, 1000, 800);
        addObject(floor4,375,239);
        addObject(floor5,760,269);
        addObject(mountainTroll,760,135);
        addObject(trollBoss,400,650);
        InvisibleWallRight invisibleWallRight = new InvisibleWallRight(100, 100);
        addObject(invisibleWallRight,929,286);
        InvisibleWallRight invisibleWallRight2 = new InvisibleWallRight(25, 25);
        addObject(invisibleWallRight2,580,200);
        InvisibleWallRight invisibleWallRight3 = new InvisibleWallRight(25, 30);
        addObject(invisibleWallRight3,255,175);
    }

    public void addPlayer(Player player)
    {
        addObject(player, 50, 90);
    }

    public int getWorldId()
    {
        return worldId;
    }
}
