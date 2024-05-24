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
        super(1200, 800, 1);
        prepare();
    }
    
    private void prepare()
    {
        setPaintOrder(Player.class, Enemy.class, Goal.class, Goal.class, InvisibleWall.class,Floor.class);
        Floor floorInicial = new Floor();
        Floor floor = new Floor();
        Floor floor2 = new Floor();
        MountainTroll mt = new MountainTroll();
        addObject(mt, 600, 450);
        addObject(floorInicial, 200, 800);
        addObject(floor, 600, 600);
        addObject(floor2, 1000, 800);
        Relleno relleno = new Relleno();
        addObject(relleno,767,715);
        relleno.setLocation(606,692);
        InvisibleWallLeft invisibleWallLeft = new InvisibleWallLeft(40, 300);
        addObject(invisibleWallLeft,405,700);
        InvisibleWallRight invisibleWallRight = new InvisibleWallRight(40, 300);
        addObject(invisibleWallRight,790,700);
    }
    
    /**
     * Agrega una instancia de la clase jugador
     * @Param El jugador con sus datos actuales, como la salud
     */
    public void addPlayer(Player player)
    {
        addObject(player, 200, 690);
    }
}
