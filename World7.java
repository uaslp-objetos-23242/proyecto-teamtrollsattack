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
        super(640,460, 1);
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
        InvisibleCeiling invisibleCeiling = new InvisibleCeiling(200, 20);
        InvisibleWallRight invisibleWallRight = new InvisibleWallRight(25, 30);
        InvisibleWallRight invisibleWallRight2 = new InvisibleWallRight(25, 50);
        InvisibleWallRight invisibleWallRight3 = new InvisibleWallRight(25, 30);
        InvisibleWallLeft invisibleWallLeft = new InvisibleWallLeft(25, 30);
        InvisibleWallLeft invisibleWallLeft2 = new InvisibleWallLeft(25, 50);
        RangerTroll rangerTroll = new RangerTroll();
        RangerTroll rangerTroll2 = new RangerTroll();
        addObject(floorInicial,90,160);
        addObject(floor,330,240);
        addObject(floor2,110,390);
        addObject(floor3,330,440);
        addObject(floor4,530,390);
        addObject(rangerTroll,110,330);
        addObject(rangerTroll2,530,330);
        addObject(invisibleCeiling,330,240);
        addObject(invisibleWallRight,420,235);
        addObject(invisibleWallRight2,204,403);
        addObject(invisibleWallRight3,185,160);
        addObject(invisibleWallLeft,240,235);
        addObject(invisibleWallLeft2,435,403);
    }

    /**
     * Agrega una instancia de la clase jugador
     * @Param El jugador con sus datos actuales, como la salud
     */
    public void addPlayer(Player player)
    {
        addObject(player, 90,90);
    }
}
