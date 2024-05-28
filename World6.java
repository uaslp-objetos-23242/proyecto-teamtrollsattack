import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase es el nivel 6 del juego
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros
 * @version 1
 */
public class World6 extends World
{
    /**
     * Constructor for objects of class World6.
     * 
     */
    public World6()
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
        setPaintOrder(Player.class, Enemy.class, Goal.class, Goal.class, InvisibleWall.class, Floor.class);
        Floor floorInicial = new Floor();
        Floor floor = new Floor();
        Floor floor2 = new Floor();
        Floor floor3 = new Floor();
        Floor floor4 = new Floor();
        TrollGeneral trollGeneral = new TrollGeneral();
        MountainTroll mountainTroll = new MountainTroll();
        InvisibleWallLeft invisibleWallLeft = new InvisibleWallLeft(25, 25);
        InvisibleWallLeft invisibleWallLeft2 = new InvisibleWallLeft(25, 35);
        InvisibleWallLeft invisibleWallLeft3 = new InvisibleWallLeft(25, 35);
        InvisibleCeiling invisibleCeiling = new InvisibleCeiling(200, 20);
        InvisibleWallRight invisibleWallRight = new InvisibleWallRight(25, 35);
        InvisibleWallRight invisibleWallRight2 = new InvisibleWallRight(25, 40);
        addObject(floorInicial, 100, 460); 
        addObject(floor, 50, 250);
        addObject(floor2, 310, 420);
        addObject(floor3, 530, 380);
        addObject(floor4, 270, 300);
        addObject(invisibleWallLeft,180, 303);
        addObject(invisibleWallLeft2,214, 423);
        addObject(invisibleWallLeft3,434,384);
        addObject(invisibleCeiling,270, 310);
        addObject(invisibleWallRight,360, 300);
        addObject(invisibleWallRight2,146, 250);
        addObject(trollGeneral,530, 320);
        addObject(mountainTroll,310, 230);
    }

    /**
     * Agrega una instancia de la clase jugador
     * @Param El jugador con sus datos actuales, como la salud
     */
    public void addPlayer(Player player)
    {
        addObject(player, 100, 400);
    }
}
