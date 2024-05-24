import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World9 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World9 extends World
{

    /**
     * Constructor for objects of class World9.
     * 
     */
    private int worldId = 9;
    public World9()
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
        Floor floor4 = new Floor();
        Floor floor5 = new Floor();
        Floor floor6 = new Floor();
        TrollGeneral trollGeneral = new TrollGeneral();
        TrollGeneral trollGeneral2 = new TrollGeneral();
        RangerTroll rangerTroll = new RangerTroll();
        addObject(floorInicial, 1150, 200);
        addObject(floor, 200, 800);
        addObject(floor2, 600, 800);
        addObject(floor3, 1000, 800);
        addObject(floor4, 720, 240);
        addObject(floor5, 200, 550);
        addObject(floor6, 600, 550);
        addObject(trollGeneral,415,432);
        addObject(trollGeneral2,810,684);
        addObject(rangerTroll,440,679);
        InvisibleCeiling invisibleCeiling = new InvisibleCeiling(900, 30);
        addObject(invisibleCeiling,353,574);
        InvisibleWallRight invisibleWallRight = new InvisibleWallRight(25, 70);
        addObject(invisibleWallRight,795, 547);
        InvisibleWallLeft invisibleWallLeft = new InvisibleWallLeft(25, 55);
        addObject(invisibleWallLeft,945,182);
        InvisibleWallLeft invisibleWallLeft2 = new InvisibleWallLeft(25, 55);
        addObject(invisibleWallLeft2,514,224);
        InvisibleCeiling invisibleCeiling2 = new InvisibleCeiling(400, 30);
        addObject(invisibleCeiling2,707,248);
    }

    public void addPlayer(Player player)
    {
        addObject(player, 1150, 95);
    }

    public int getWorldId()
    {
        return worldId;
    }
}
