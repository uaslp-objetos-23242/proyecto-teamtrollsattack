import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase es el nivel 8 del juego
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros 
 * @version 1
 */
public class World8 extends World
{
    /**
     * Constructor for objects of class World8.
     * 
     */
    public World8()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640,460, 1);
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
        InvisibleWallRight invisibleWallRight = new InvisibleWallRight(25, 55);
        InvisibleWallLeft invisibleWallLeft = new InvisibleWallLeft(25, 55);
        addObject(floorInicial, getWidth()/2, getHeight()/2 - 100);
        addObject(floor, 100, 460);
        addObject(floor2, 315, 460);
        addObject(floor3, 533, 460);
        addObject(mountainTroll,100, 390);
        addObject(mountainTroll2,315, 390);
        addObject(mountainTroll3,533, 390);
        addObject(invisibleWallRight,getWidth()/2 + 95, getHeight()/2 - 85);
        addObject(invisibleWallLeft,getWidth()/2 - 95, getHeight()/2 - 85);
    }

    /**
     * Agrega una instancia de la clase jugador
     * @Param El jugador con sus datos actuales, como la salud
     */
    public void addPlayer(Player player)
    {
        addObject(player, getWidth()/2, getHeight()/2 - 410);
    }
}
