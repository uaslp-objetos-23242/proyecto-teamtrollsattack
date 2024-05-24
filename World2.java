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

    /**
     * Agrega una instancia de la clase jugador
     * @Param El jugador con sus datos actuales, como la salud
     */
    public void addPlayer(Player player)
    {
        addObject(player, 1100, 190);
    }
}
