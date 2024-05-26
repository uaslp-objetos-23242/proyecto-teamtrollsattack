import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase es el nivel 4 del juego
 * 
 * @author Miguel Angel Enriquez Cisneros y Joaquin Manuel Trujillo Viveros 
 * @version 1
 */
public class World4 extends World
{
    /**
     * Constructor for objects of class World4.
     * 
     */
    public World4()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        prepare();
    }
    
    private void prepare()
    {
        setPaintOrder(Player.class, Enemy.class, Goal.class, Goal.class, Floor.class);
        Floor floorInicial = new Floor();
        Floor floor = new Floor();
        Floor floor2 = new Floor();
        Floor floor3 = new Floor();
        Floor floor4 = new Floor();
        RangerTroll rangerTroll = new RangerTroll();
        TrollGeneral trollGeneral = new TrollGeneral();
        addObject(floorInicial, 1150, 200);
        addObject(floor, 200, 800);
        addObject(floor2, 600, 800);
        addObject(floor3, 1000, 800);
        addObject(rangerTroll,170,685);
        addObject(trollGeneral,400,685);
    }
    
    /**
     * Agrega una instancia de la clase jugador
     * @Param El jugador con sus datos actuales, como la salud
     */
    public void addPlayer(Player player)
    {
        addObject(player, 1150, 90);
    }
}
