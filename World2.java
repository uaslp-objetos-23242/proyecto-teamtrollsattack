import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase es el nivel 2 del juego
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros 
 * @version 1
 */
public class World2 extends World
{
    /**
     * Constructor for objects of class World2.
     * 
     */
    public World2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640,460, 1); 
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
        InvisibleWallRight invisibleWallRight = new InvisibleWallRight(50, 50);
        addObject(floorInicial, 600, 150);
        addObject(floor, 100, 420);
        addObject(floor2, 315, 460);
        addObject(floor3, 533, 460);
        addObject(invisibleWallRight,183,427);
        addObject(rt, 533, 400);
    }

    /**
     * Agrega una instancia de la clase jugador
     * @Param El jugador con sus datos actuales, como la salud
     */
    public void addPlayer(Player player)
    {
        addObject(player, 580, 60);
    }
}
