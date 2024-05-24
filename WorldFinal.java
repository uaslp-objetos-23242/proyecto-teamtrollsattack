import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldFinal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldFinal extends World
{

    private int worldId = 10;
    GreenfootSound risaTrollBoss = new GreenfootSound("Risa_Troll_Boss.mp3");
    private boolean risaYaActivada = false;
    /**
     * Constructor for objects of class WorldFinal.
     * 
     */
    public WorldFinal()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        prepare();
        risaTrollBoss.setVolume(80);
    }
    
    public void act()
    {
        if(!risaYaActivada)
            risa();
    }

    private void prepare()
    {
        setPaintOrder(Player.class, Enemy.class, Goal.class, Goal.class, Floor.class);
        Floor floorInicial = new Floor();
        Floor floor = new Floor();
        Floor floor2 = new Floor();
        Floor floor3 = new Floor();
        Floor floor4 = new Floor();
        addObject(floorInicial, 50, 200);
        addObject(floor, 200, 800);
        addObject(floor2, 600, 800);
        addObject(floor3, 1000, 800);
        TrollBoss trollBoss = new TrollBoss(true);
        addObject(trollBoss,800,620);
    }
    
    public void risa()
    {
        risaTrollBoss.play();
        risaYaActivada = true;
    }

    public void addPlayer(Player player)
    {
        addObject(player, 200, 95);
    }

    public int getWorldId()
    {
        return worldId;
    }
}
