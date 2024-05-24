import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase es el nivel 7 del juego
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class World7 extends World
{

    /**
     * Constructor for objects of class World7.
     * 
     */
    public World7()
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
        setPaintOrder(Player.class, Enemy.class, Goal.class, InvisibleWall.class, Floor.class);
        Floor floorInicial = new Floor();
        Floor floor = new Floor();
        Floor floor2 = new Floor();
        Floor floor3 = new Floor();
        Floor floor4 = new Floor();
        addObject(floorInicial,220,160);
        addObject(floor,623,398);
        addObject(floor2,210,650);
        addObject(floor3,990,650);
        addObject(floor4,600,760);
        RangerTroll rangerTroll = new RangerTroll();
        addObject(rangerTroll,1074,530);
        RangerTroll rangerTroll2 = new RangerTroll();
        addObject(rangerTroll2,102,530);
        InvisibleCeiling invisibleCeiling = new InvisibleCeiling(400, 30);
        addObject(invisibleCeiling,220,160);
        InvisibleWallRight invisibleWallRight = new InvisibleWallRight(25, 50);
        addObject(invisibleWallRight,408,140);
        InvisibleWallLeft invisibleWallLeft = new InvisibleWallLeft(25, 50);
        addObject(invisibleWallLeft,423,373);
        InvisibleCeiling invisibleCeiling2 = new InvisibleCeiling(400, 30);
        addObject(invisibleCeiling2,620,401);
        InvisibleWallRight invisibleWallRight2 = new InvisibleWallRight(25, 50);
        addObject(invisibleWallRight2,818,380);
        InvisibleWallLeft invisibleWallLeft2 = new InvisibleWallLeft(100, 100);
        addObject(invisibleWallLeft2,823,665);
        InvisibleWallRight invisibleWallRight3 = new InvisibleWallRight(100, 100);
        addObject(invisibleWallRight3,377,665);
    }

    /**
     * Agrega una instancia de la clase jugador
     * @Param El jugador con sus datos actuales, como la salud
     */
    public void addPlayer(Player player)
    {
        addObject(player, 250, 52);
    }
}
