import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase es el nivel 3 del juego
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros 
 * @version 1
 */
public class World3 extends World
{
    /**
     * Constructor for objects of class World3.
     * 
     */
    public World3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640,460, 1);
        prepare();
    }
    
    private void prepare()
    {
        setPaintOrder(Player.class, Enemy.class, Goal.class, Goal.class, InvisibleWall.class,Floor.class);
        Floor floorInicial = new Floor();
        Floor floor = new Floor();
        Floor floor2 = new Floor();
        Relleno relleno = new Relleno();
        MountainTroll mt = new MountainTroll();
        InvisibleWallLeft invisibleWallLeft = new InvisibleWallLeft(40, 150);
        InvisibleWallRight invisibleWallRight = new InvisibleWallRight(40, 150);
        addObject(floorInicial, 100, 460);
        addObject(floor, 318, 380);
        addObject(floor2, 533, 460);
        addObject(relleno,318,450);
        addObject(invisibleWallLeft,230,445);
        addObject(invisibleWallRight,405,445);
        addObject(mt, 318, 310);
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
